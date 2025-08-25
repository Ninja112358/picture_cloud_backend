package com.ninja.picture_cloud_backend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ninja.picture_cloud_backend.model.dto.picture.PictureQueryRequest;
import com.ninja.picture_cloud_backend.model.dto.picture.PictureUploadRequest;
import com.ninja.picture_cloud_backend.model.dto.user.UserQueryRequest;
import com.ninja.picture_cloud_backend.model.entity.Picture;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ninja.picture_cloud_backend.model.entity.User;
import com.ninja.picture_cloud_backend.model.vo.PictureVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
* @author Ninja
* @description 针对表【picture(图片)】的数据库操作Service
* @createDate 2025-08-12 15:55:40
*/
public interface PictureService extends IService<Picture> {
    /**
     * 校验图片
     * @param picture 图片
     */
    void validPicture(Picture picture);

    /**
     * 上传图片
     * @param multipartFile 图片文件
     * @param pictureUploadRequest 图片上传请求
     * @param loginUser 登录用户
     * @return 图片包装类
     */
    PictureVO uploadPicture(MultipartFile multipartFile, PictureUploadRequest pictureUploadRequest, User loginUser);

    /**
     * 获取图片包装类(单条)
     * @param picture 图片
     * @param request 请求
     * @return 图片包装类
     */
    PictureVO getPictureVO(Picture picture, HttpServletRequest request);
    /**
     * 获取图片包装类(分页)
     * @param picturePage 图片
     * @param request 请求
     * @return 图片包装类
     */
    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);

    /**
     * 获取查询条件
     * @param pictureQueryRequest 查询请求
     * @return 查询条件
     */
    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);
}
