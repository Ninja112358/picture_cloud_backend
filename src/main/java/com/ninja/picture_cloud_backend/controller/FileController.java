package com.ninja.picture_cloud_backend.controller;

import com.ninja.picture_cloud_backend.annotation.AuthCheck;
import com.ninja.picture_cloud_backend.common.BaseResponse;
import com.ninja.picture_cloud_backend.common.ResultUtils;
import com.ninja.picture_cloud_backend.constant.UserConstant;
import com.ninja.picture_cloud_backend.exception.BusinessException;
import com.ninja.picture_cloud_backend.exception.ErrorCode;
import com.ninja.picture_cloud_backend.manager.CosManager;
import com.qcloud.cos.model.COSObject;
import com.qcloud.cos.model.COSObjectInputStream;
import com.qcloud.cos.utils.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {
    @Resource
    private CosManager cosManager;
    String CosFilePath = "avatar";
    /**
     * 文件上传
     *
     * @param multipartFile 文件
     */
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    @PostMapping("/upload")
    public BaseResponse<String> uploadFile(@RequestPart("file")MultipartFile multipartFile){
        String filename = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
        String filepath = String.format("/%s/%s",CosFilePath, filename);
        File file = null;
        try {
            //上传文件
            file = File.createTempFile(filepath, null);
            multipartFile.transferTo(file);
            cosManager.putObject(filepath, file);
            //返回可访问的地址
            return ResultUtils.success(filepath);
        } catch (IOException e) {
            log.error("file upload error, filepath: " + filepath, e);
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "上传文件失败");
        }finally {
            if(file != null){
                //删除临时文件
                boolean delete = file.delete();
                if(!delete)
                    log.error("temp file delete error, filepath: " + filepath);
            }
        }
    }
    /**
     * 文件下载
     *
     * @param filepath 文件路径
     * @param response 响应对象
     */
    @GetMapping("/download/")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public void downloadFile(String filepath, HttpServletResponse response) throws IOException {
        COSObjectInputStream cosObjectInput = null;
        try {
            COSObject cosObject = cosManager.getObject(filepath);
            cosObjectInput = cosObject.getObjectContent();
            // 处理下载到的流
            byte[] bytes = IOUtils.toByteArray(cosObjectInput);
            // 设置响应头
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + filepath);
            // 写入响应
            response.getOutputStream().write(bytes);
            response.getOutputStream().flush();
        } catch (Exception e) {
            log.error("file download error, filepath = " + filepath, e);
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "下载失败");
        } finally {
            if (cosObjectInput != null) {
                cosObjectInput.close();
            }
        }
    }

}
