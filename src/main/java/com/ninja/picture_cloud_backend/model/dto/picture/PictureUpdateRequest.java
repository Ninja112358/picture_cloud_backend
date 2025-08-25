package com.ninja.picture_cloud_backend.model.dto.picture;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 图片更新请求类
 */
@Data
public class PictureUpdateRequest implements Serializable {
    /**
     * 图片id
     */
    private Long id;
    /**
     * 图片名称
     */
    private String name;
    /**
     * 图片描述
     */
    private String introduction;
    /**
     * 图片分类
     */
    private String category;
    /**
     * 图片标签列表
     */
    private List<String> tags;

    private static final long serialVersionUID = 1L;
}
