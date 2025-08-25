package com.ninja.picture_cloud_backend.model.enums;

import cn.hutool.core.util.ObjUtil;
import com.ninja.picture_cloud_backend.constant.UserConstant;
import lombok.Data;
import lombok.Getter;

/**
 * UserRoleEnum
 * @author ninja
 * @description: 用户角色枚举
 */
@Getter
public enum UserRoleEnum {
    USER("用户",UserConstant.USER_ROLE),
    ADMIN("管理员", UserConstant.ADMIN_ROLE);
    private final String text;
    private final String value;
    UserRoleEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }
    public static UserRoleEnum getEnumByValue(String value) {
        if(ObjUtil.isEmpty(value)){
            return null;
        }
        for (UserRoleEnum userRoleEnum : UserRoleEnum.values()) {
            if (userRoleEnum.value.equals(value)) {
                return userRoleEnum;
            }
        }
        return null;
    }
}
