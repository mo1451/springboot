package com.mo1451.boot.mybatis.service;

import com.mo1451.boot.mybatis.dto.Permission;
import com.mo1451.boot.mybatis.dto.Role;
import com.mo1451.boot.mybatis.dto.User;
import com.mo1451.boot.mybatis.mapper.PermissionMapper;
import com.mo1451.boot.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MybatisUserService implements UserDetailsService{

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<Permission> permissions = permissionMapper.findByAdminUserId(user.getUserId());
        /*List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
        for(Role role:user.getRoles())
        {
            authorities.add(new SimpleGrantedAuthority(role.getRoleCode()));
            System.out.println(role.getRoleCode());
        }*/
        List<GrantedAuthority> grantedAuthorities = new ArrayList <>();
        for (Permission permission : permissions) {
            if (permission != null && permission.getRuleCode()!=null) {

                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getRuleCode());
                //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                grantedAuthorities.add(grantedAuthority);
            }
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword(), grantedAuthorities);
    }

    public List<User> getList(){
        return userMapper.selectUsers();
    }

    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }
}
