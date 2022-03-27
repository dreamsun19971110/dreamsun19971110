package com.dream.user_center.controller;


import com.dream.user_center.entity.User;
import com.dream.user_center.entity.Vo.userVo;
import com.dream.user_center.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api")
public class userController {
    @Resource
    private UserService userService;


    /**
     * 用户登录
     * @param vo
     * @return
     */
    @PostMapping("/user/login")
    User loginUser(@RequestBody userVo vo,HttpServletRequest request){
        //在这里也要校验一下当前账户密码是否存在,如果不存在的话,就没必要进入服务层进行判断
        String userName = vo.getUserName();
        String passWord = vo.getPassWord();
        if (StringUtils.isAllBlank(userName,passWord)) {
            return null;
        }
        return  userService.loginUser(userName, passWord, request);
    }


    //用户查询
    //用户删除

    @GetMapping("/user/delete/{id}")
    Boolean deleteUser(@PathVariable("id") int id,HttpServletRequest request){
        //删除用户只有管理员才能够进行删除
        User loginUser = (User) request.getAttribute("loginUser");
        if (loginUser.getUserrule() != 1){
            //当前登录用户未普通用户
            return null;
        }
        return  userService.removeById(id);

    }



}
