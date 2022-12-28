package com.org.Handler;

import com.org.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

//认证逻辑
@Component
public class SelfAuthenticationProvider implements AuthenticationProvider{
    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String account= authentication.getName();     //获取session用户名
        String password= (String) authentication.getCredentials();  //获取session密码
        UserDetails userDetails= userService.loadUserByUsername(account);  //数据库查询密码
        boolean checkPassword= bCryptPasswordEncoder.matches(password,userDetails.getPassword());  //比对session和数据库的密码
        if(!checkPassword){
            throw new BadCredentialsException("密码不正确，请重新登录!");
        }
        return new UsernamePasswordAuthenticationToken(account,password,userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
