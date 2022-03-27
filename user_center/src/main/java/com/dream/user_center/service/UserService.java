package com.dream.user_center.service;

import com.dream.user_center.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
* @author DreamSun
* @description 针对表【user】的数据库操作Service
* @createDate 2022-03-20 20:32:43
*/
public interface UserService extends IService<User> {


    /**用户注册
     * @param userName 用户名
     * @param passWord 密码
     * @param checkPassword 确认码
     * @return 用户id
     */
    long userRegeist(String userName,String passWord,String checkPassword);


    /**用户登录
     * @param userName
     * @param passWord
     * @return 脱敏后的用户信息
     */
    User loginUser(String userName, String passWord, HttpServletRequest request);


}
