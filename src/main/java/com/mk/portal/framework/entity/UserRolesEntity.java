package com.mk.portal.framework.entity;
// Generated 10 Jul, 2015 6:28:51 PM by Hibernate Tools 3.2.2.GA



/**
 * UserRolesEntity generated by hbm2java
 */
public class UserRolesEntity  implements java.io.Serializable {


     private UserEntity user;
     private RolesEntity role;

    public UserRolesEntity() {
    }

    public UserRolesEntity(UserEntity user, RolesEntity role) {
       this.user = user;
       this.role = role;
    }
   
    public UserEntity getUser() {
        return this.user;
    }
    
    public void setUser(UserEntity user) {
        this.user = user;
    }
    public RolesEntity getRole() {
        return this.role;
    }
    
    public void setRole(RolesEntity role) {
        this.role = role;
    }




}


