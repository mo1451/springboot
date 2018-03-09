package com.mo1451.boot.mybatis.mapper;

import com.mo1451.boot.mybatis.dto.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {
    public List<Permission> findAll();
    public List<Permission> findByAdminUserId(Long userId);
}
