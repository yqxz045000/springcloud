package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * 
 * @author cfyj
 * 2017年9月6日 下午5:43:32
 * jpa接口
 *
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByUsername(String username);
}
