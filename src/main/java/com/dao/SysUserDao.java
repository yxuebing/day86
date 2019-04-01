package com.dao;

import com.pojo.SysRole;
import com.pojo.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysUserDao extends JpaRepository<SysUser,Integer>,JpaSpecificationExecutor<SysUser> {
}
