package com.ninja.picture_cloud_backend.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: ninja
 * 用户注册请求DTO
 */
@Data
public class UserRegisterRequest implements Serializable {
    private static final long serialVersionUID = 5874567786720835491L;
    private String userAccount;
    private String userPassword;
    private String checkPassword;
}
