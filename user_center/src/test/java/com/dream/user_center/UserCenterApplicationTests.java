package com.dream.user_center;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import com.dream.user_center.entity.User;
import com.dream.user_center.service.UserService;


import org.junit.Assert;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

@SpringBootTest
class UserCenterApplicationTests {

    @Resource
    private UserService userService;

    @Test
    public void testSelect() {
        User user = new User();
        user.setId(0);
        user.setUsername("dreamsun");
        user.setPassword("123456789");
        user.setSex(0);
        user.setPhone(0);
        user.setEmail("");
        user.setHandurl("");
        user.setUserrule(0);
        user.setIsdelect(0);
        user.setCreatetiem(new Date());
        user.setUpdatetime(new Date());
        userService.save(user);

    }

    @Test
    public void testMd5() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String passWord = "123456";
        String salt = "dream";
        String saltPassWord = salt + passWord;
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] passWordBytes = saltPassWord.getBytes("UTF-8");
        byte[] digest = md5.digest(passWordBytes);
        String newPassWord = digest.toString();


        String result = DigestUtils.md5DigestAsHex((salt + passWord).getBytes());
        System.out.println(result);
    }

    @Test
    public void userRedist(){
        String username = "dreamsun";
        String password = "";
        String checkpassword = "123456";
        long result = userService.userRegeist(username, password, checkpassword);
        Assert.assertEquals(-1,result);

        username = "dre";
        password = "12345678";
        result = userService.userRegeist(username, password, checkpassword);
        Assert.assertEquals(-1,result);
        username = "dreamsun";
        password = "123456";
        result = userService.userRegeist(username, password, checkpassword);
        Assert.assertEquals(-1,result);
        password = "123456";
        checkpassword = "1234567";
        result = userService.userRegeist(username, password, checkpassword);
        Assert.assertEquals(-1,result);
        password = "12345678&";
        checkpassword = "12345678&";
        result = userService.userRegeist(username, password, checkpassword);
        Assert.assertEquals(-1,result);
        username = "testdreamsun";
        password = "12345678";
        checkpassword = "12345678";
        result = userService.userRegeist(username, password, checkpassword);
        System.out.println(result);

    }



}
