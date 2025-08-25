package com.ninja.picture_cloud_backend.model.dto.user;

import com.ninja.picture_cloud_backend.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 用户查询请求类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserQueryRequest extends PageRequest implements Serializable {
    private Long id;
    private String userName;
    private String userAccount;
    private String userProfile;
    private String userRole;
    private static final long serialVersionUID = 1L;
}
