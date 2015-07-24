package com.mk.portal.framework.entity;
// Generated 24 Jul, 2015 2:29:11 PM by Hibernate Tools 3.2.2.GA


import java.util.HashSet;
import java.util.Set;

/**
 * UserEntity generated by hbm2java
 */
public class UserEntity  implements java.io.Serializable {


     private int userId;
     private String username;
     private String password;
     private boolean enabled;
     private Set<UserRolesEntity> userRole = new HashSet<UserRolesEntity>(0);

    public UserEntity() {
    }

	
    public UserEntity(String password, boolean enabled) {
        this.password = password;
        this.enabled = enabled;
    }
    public UserEntity(String username, String password, boolean enabled, Set<UserRolesEntity> userRole) {
       this.username = username;
       this.password = password;
       this.enabled = enabled;
       this.userRole = userRole;
    }
   
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isEnabled() {
        return this.enabled;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public Set<UserRolesEntity> getUserRole() {
        return this.userRole;
    }
    
    public void setUserRole(Set<UserRolesEntity> userRole) {
        this.userRole = userRole;
    }




}


