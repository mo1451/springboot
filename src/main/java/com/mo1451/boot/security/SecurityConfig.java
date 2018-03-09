package com.mo1451.boot.security;

import com.mo1451.boot.mybatis.service.MybatisUserService;
import com.mo1451.boot.security.service.MyFilterSecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;


@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;

    @Bean
    UserDetailsService customUserService() { //注册UserDetailsService 的bean
        return new MybatisUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //   auth.userDetailsService(customUserService()).passwordEncoder(new StandardPasswordEncoder()); //user Details Service验证
        auth.userDetailsService(customUserService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                //   .anyRequest().authenticated() //任何请求,登录后可以访问
                .antMatchers("/soap/**", "/ws/**", "/ws", "/soap").permitAll()
                .anyRequest().authenticated() //任何请求,登录后可以访问
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .permitAll() //登录页面用户任意访问
                .and().logout().permitAll() //注销行为任意访问
                .and().csrf().ignoringAntMatchers("/soap/**", "/ws/**", "/ws", "/soap")
                .and().httpBasic();
           //     .and().csrf().disable();


        /*((HttpSecurity)
                ((HttpSecurity)
                ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)http.authorizeRequests().anyRequest())
                .authenticated().and())
                        .formLogin().and()).httpBasic();*/

        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
    }
}
