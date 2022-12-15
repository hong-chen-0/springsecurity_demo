package com.org.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.org.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends JpaRepository<User,Integer> {
    User findByAccount(String s);
}
