package com.dao;

import com.pojo.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysRoleDao extends JpaRepository<SysRole,Integer>,JpaSpecificationExecutor<SysRole> {
}
