package com.mo1451.boot.jdbc.service;

import com.mo1451.boot.jdbc.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class JdbcUserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getList(){
        String sql = "SELECT USER_ID,USER_NAME,PASSWORD_ENCRYPTED,EMAIL,PHONE,START_ACTIVE_DATE,END_ACTIVE_DATE FROM sys_user";
        return (List<User>) jdbcTemplate.query(sql, new RowMapper<User>(){
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setUserId(rs.getLong("USER_ID"));
                user.setUserName(rs.getNString("USER_NAME"));
                user.setPasswordEncrypted(rs.getString("PASSWORD_ENCRYPTED"));
                user.setEmail(rs.getString("EMAIL"));
                user.setPhone(rs.getString("PHONE"));
                user.setStartActiveDate(rs.getDate("START_ACTIVE_DATE"));
                user.setEndActiveDate(rs.getDate("END_ACTIVE_DATE"));
                return user;
            }

        });
    }
}
