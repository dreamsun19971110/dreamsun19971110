package com.dream.user_center.service.impl;
import java.util.Date;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dream.user_center.entity.User;
import com.dream.user_center.service.UserService;
import com.dream.user_center.mapper.UserMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @author DreamSun
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-03-20 20:32:43
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Override
    public long userRegeist(String userName, String passWord, String checkPassword)  {
        if (StringUtils.isAllBlank(userName,passWord,checkPassword)){
            return -1;
        }
        if (StringUtils.isEmpty(userName) && StringUtils.isEmpty(passWord)){
            return -1;
        }
        if (userName.length() <=4 || passWord.length() <= 6){
            return  -1;
        }
        //用户名和密码不能存在特殊字符
        String regEx = "[_`!@#$%^&*()+=|{}’:;’,.<>/?！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m1 = p.matcher(userName);
        Matcher m2 = p.matcher(userName);
        if (m1.find() || m2.find()){
            //表明username存在特殊字符
            return -1;
        }
        //密码和校验码要相同才可以
        if (passWord != checkPassword){
            return -1;
        }
        //对密码进行加密
        final String salt = "dream";
        String newPassword = DigestUtils.md5DigestAsHex((salt + passWord).getBytes());
        //不能存在相同的用户信息
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername,userName);
        User result = this.getOne(wrapper);
        if (result != null){
            return -1;
        }
        //将数据保存到数据库中
        User user = new User();
        user.setId(0);
        user.setUsername(userName);
        user.setPassword(newPassword);
        user.setCreatetiem(new Date());
        user.setUpdatetime(new Date());
        this.save(user);

        return user.getId();
    }

    @Override
    public User loginUser(String userName, String passWord, HttpServletRequest request) {
        //账号密码不能为空
        if (StringUtils.isAllBlank(userName,passWord)){
            return null;
        }
        if (userName.length() <=4 || passWord.length() <= 6){
            return  null;
        }
        //用户名和密码不能存在特殊字符
        String regEx = "[_`!@#$%^&*()+=|{}’:;’,.<>/?！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m1 = p.matcher(userName);
        Matcher m2 = p.matcher(userName);
        if (m1.find() || m2.find()){
            //表明username存在特殊字符
            return null;
        }
        //查询当前角色是否存在
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername,userName);
        User user = this.getOne(wrapper);
        if (ObjectUtils.isEmpty(user)){
            return null;
        }
        //对当前数据进行脱敏
        User saftUser = saftUser(user);
        //保存当前登录状态
        request.setAttribute("loginUser",saftUser);
        return saftUser;
    }


    /**
     * 对用户信息进行简单脱敏工作
     * @param user
     * @return
     */
    public User saftUser(User user){
        //对当前数据进行脱敏
        User saftUser = new User();
        saftUser.setId(user.getId());
        saftUser.setUsername(user.getUsername());
//        user.setPassword("");
        saftUser.setSex(user.getSex());
        saftUser.setPhone(user.getPhone());
        saftUser.setEmail(user.getEmail());
        saftUser.setHandurl(user.getHandurl());
        saftUser.setUserrule(user.getUserrule());
//        user.setIsdelect(0);
        saftUser.setCreatetiem(user.getCreatetiem());
        saftUser.setUpdatetime(user.getUpdatetime());
        return saftUser;
    }



}




