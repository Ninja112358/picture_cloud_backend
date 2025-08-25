package com.ninja.picture_cloud_backend.constant;

/**
 * 用户常量
 */
public interface UserConstant {
    /**
     * 用户登录状态
     */
    String USER_LOGIN_STATE = "user_login";
    /**
     * 加密盐值
     */
    String ENCRYPTION_SALT = "ninja";
    //region 权限
    /**
     * 默认角色（普通用户）
     */
    String DEFAULT_ROLE = "user";
    /**
     * 普通用户角色
     */
    String USER_ROLE = "user";
    /**
     * 管理员角色
     */
    String ADMIN_ROLE = "admin";
    //endregion

    //region 用户初始信息
    //用户初始头像
    String DEFAULT_AVATAR = "https://ninja-1304954331.cos.ap-beijing.myqcloud.com/test/1755676915694_zhin.png";
    //用户初始昵称
    String DEFAULT_NAME = "无名";
    //用户初始简介
    String DEFAULT_PROFILE = "这个人没有填简介啊~~~";
    //endregion
}
