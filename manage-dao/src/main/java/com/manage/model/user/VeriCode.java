package com.manage.model.user;

public class VeriCode {
    //id
    private Integer id;
    //用户姓名
    private Integer userid;
    //验证码
    private String vericode;
    //超时时间
    private String vericodeExpired;
    //创建时间
    private String createTime;
    //删除状态
    private Integer deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUser_id(Integer userid) {
        this.userid = userid;
    }

    public String getVericode() {
        return vericode;
    }

    public void setVericode(String vericode) {
        this.vericode = vericode;
    }

    public String getVericodeExpired() {
        return vericodeExpired;
    }

    public void setVericodeExpired(String vericodeExpired) {
        this.vericodeExpired = vericodeExpired;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "UserManager{" +
                "id=" + id +
                ", userid='" + userid + '\'' +
                ", vericode='" + vericode + '\'' +
                ", vericodeExpired='" + vericodeExpired + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
