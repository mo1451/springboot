package com.mo1451.boot.mybatis.mapper;

import com.mo1451.boot.mybatis.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> selectUsers();

    User findByUserName(String userName);
}
