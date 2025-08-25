package com.ninja.picture_cloud_backend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ninja.picture_cloud_backend.model.dto.user.UserQueryRequest;
import com.ninja.picture_cloud_backend.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ninja.picture_cloud_backend.model.vo.LoginUserVO;
import com.ninja.picture_cloud_backend.model.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author Ninja
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2025-03-24 18:04:35
*/
public interface UserService extends IService<User> {
    /**
     * 用户注册方法
     * @param userAccount 用户账号
     * @param userPassword 用户密码
     * @param checkPassword 确认密码
     * @return long
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 用户登录方法
     * @param userAccount 用户账号
     * @param userPassword 用户密码
     * @param request http请求
     * @return 登录后的用户信息
     */
    LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request);
    /**
     * 获取加密密码
     * @param userPassword 用户密码
     * @return 加密后的密码
     */
    String getEncryptPassword(String userPassword);

    /**
     * 获取当前登录用户
     * @param request http请求
     * @return 当前登录用户
     */
    User getLoginUser(HttpServletRequest request);
    /**
     * 获取脱敏后的登录用户信息
     * @param user 用户信息
     * @return 脱敏后的用户信息
     */
    LoginUserVO getLoginUserVO(User user);

    /**
     * 获取脱敏后的用户信息
     * @param user 用户信息
     * @return 脱敏后的用户信息
     */
    UserVO getUserVO(User user);

    /**
     * 获取脱敏后的用户信息列表
     * @param userList 用户信息列表
     * @return 脱敏后的用户信息列表
     */
    List<UserVO> getUserVOList(List<User> userList);

    /**
     * 用户注销方法
     * @param request http请求
     */
    boolean userLogout(HttpServletRequest request);

    /**
     * 获取查询条件
     * @param userQueryRequest 查询请求
     * @return 查询条件
     */
    QueryWrapper<User> getQueryWrapper(UserQueryRequest userQueryRequest);
    /**
     * 是否为管理员
     * @param user 用户
     * @return 是否为管理员
     */
    boolean isAdmin(User user);
}
