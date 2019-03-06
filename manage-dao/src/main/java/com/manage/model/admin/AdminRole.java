package com.manage.model.admin;



import java.text.SimpleDateFormat;
import java.util.Date;

public class AdminRole {
    private int roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 用户
     */
    private String userList;

    /**
     *角色描述
     */
    private String remark;
    /**
     *
     */
    private String websiteRole;
    private String createTime;
    private Date updateTime;
    /**
     *
     */
    private int isDelete;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserList() {
        return userList;
    }

    public void setUserList(String userList) {
        this.userList = userList;
    }



    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getWebsiteRole() {
        return websiteRole;
    }

    public void setWebsiteRole(String websiteRole) {
        this.websiteRole = websiteRole;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        if (createTime != null){
            String date=simpleDateFormat.format(createTime);
            this.createTime =  date;
        }
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "AdminRole{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", userList='" + userList + '\'' +
                ", remark='" + remark + '\'' +
                ", websiteRole='" + websiteRole + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                '}';
    }
}
