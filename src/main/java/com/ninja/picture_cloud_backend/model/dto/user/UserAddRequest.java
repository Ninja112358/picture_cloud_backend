package com.ninja.picture_cloud_backend.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 添加用户请求类
 */
@Data
public class UserAddRequest implements Serializable {
    private String userName;
    private String userAccount;
    private String userAvatar;
    private String userProfile;
    private String userRole;
    private static final long serialVersionUID = 1L;
}
