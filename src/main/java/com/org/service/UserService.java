package com.org.service;

import com.org.entity.User;
import com.org.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    //加载用户
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userMapper.findByAccount(s);    //user即为查询结果
        if(user==null){
            throw new UsernameNotFoundException("用户名错误！！");
        }

        //获取用户权限，并把其添加到GrantedAuthority中
        List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
        GrantedAuthority grantedAuthority=new SimpleGrantedAuthority(user.getRole());
        grantedAuthorities.add(grantedAuthority);

        //方法的返回值要求返回UserDetails这个数据类型，  UserDetails是接口，找它的实现类就好了
        //new org.springframework.security.core.userdetails.User(String username,String password,Collection<? extends GrantedAuthority> authorities) 就是它的实现类
        return new org.springframework.security.core.userdetails.User(s,user.getPassword(),grantedAuthorities);
    }

}
