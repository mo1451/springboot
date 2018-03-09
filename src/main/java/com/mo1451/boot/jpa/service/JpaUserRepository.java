package com.mo1451.boot.jpa.service;

import com.mo1451.boot.jpa.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<User, Long> {

}
