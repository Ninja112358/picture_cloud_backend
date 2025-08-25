package com.ninja.picture_cloud_backend.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: ninja
 * @description: 用户视图对象(脱敏)
 */
@Data
public class UserVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String userAccount;
    private String userName;
    private String userAvatar;
    private String userProfile;
    private String userRole;
    private Date createTime;
    private Date updateTime;
    private Boolean isDelete;
}
