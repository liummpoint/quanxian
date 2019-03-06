package com.manage.model.user;

public class UserManager {
    //用户id
    private Integer id;
    //用户姓名
    private String userName;
    //用户手机号
    private String mobile;
    //用户邮箱
    private String email;
    //创建时间
    private String createTime;
    private String updateTime;
    private String creator;
    private String updator;
    //备注信息
    private String remark;
    //删除状态
    private Integer deleted;
    //密码
    private String password;
    //用户状态信息
    private Integer status;
    //角色id
    private Integer roleId;
    //角色名称
    private String roleName;
    private String oper;
    //用户角色
    //确认密码
    private String password2;
    private int startSize;
    private int size;

    //输入次数
    private String inputnum;
    //锁定时间
    private String locktime;
    //提醒修改密码时间
    private String needtime;
    //登录sessionid
    private String loginsessionid;

    public String getLoginsessionid() {
        return loginsessionid;
    }

    public void setLoginsessionid(String loginsessionid) {
        this.loginsessionid = loginsessionid;
    }

    public String getNeedtime() {
        return needtime;
    }

    public void setNeedtime(String needtime) {
        this.needtime = needtime;
    }

    public String getInputnum() {
        return inputnum;
    }

    public void setInputnum(String inputnum) {
        this.inputnum = inputnum;
    }

    public String getLocktime() {
        return locktime;
    }

    public void setLocktime(String locktime) {
        this.locktime = locktime;
    }


    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public void setCreateTime(String createTime) {

        this.createTime = createTime;
    }


    public int getStartSize() {
        return startSize;
    }

    public void setStartSize(int startSize) {
        this.startSize = startSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getOper() {
        if (oper == null) {
            return "";
        } else {
            return oper;
        }

    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    @Override
    public String toString() {
        return "UserManager{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", creator='" + creator + '\'' +
                ", updator='" + updator + '\'' +
                ", remark='" + remark + '\'' +
                ", deleted=" + deleted +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", oper='" + oper + '\'' +
                ", password2='" + password2 + '\'' +
                ", startSize=" + startSize +
                ", size=" + size +
                '}';
    }
}
