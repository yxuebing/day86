package com.pojo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity  //  如果类名与数据库名字一样可以省略@Table注解
public class SysUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String username;
    private String password;
@ManyToMany(targetEntity = SysRole.class,mappedBy = "users",cascade = CascadeType.ALL)
//@JoinTable(name = "SysUserRoleRef",
//joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "userId")},
//        inverseJoinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "roleId")}
//)
 private Set<SysRole> roles = new HashSet<>(0);

    public Set<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SysRole> roles) {
        this.roles = roles;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

