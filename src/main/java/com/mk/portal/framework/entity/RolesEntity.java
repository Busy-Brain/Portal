package com.mk.portal.framework.entity;
// Generated 16 Jul, 2015 3:51:50 PM by Hibernate Tools 3.2.2.GA



/**
 * RolesEntity generated by hbm2java
 */
public class RolesEntity  implements java.io.Serializable {


     private int roleId;
     private String roleName;

    public RolesEntity() {
    }

    public RolesEntity(String roleName) {
       this.roleName = roleName;
    }
   
    public int getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }




}


