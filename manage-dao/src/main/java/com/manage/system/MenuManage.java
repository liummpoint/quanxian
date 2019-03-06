package com.manage.system;

public class MenuManage {
    private int id;
    private String name;
    private String url;
    private int parentId;
    private String isDeleted;
    private String createTime;
    private String icon;
    private String updateTime;
    private String sort;
    private String sessionKey;
    private String parentName;
    private int menuGrade;//菜单级别
    private int type;//菜单类型：  0  菜单  1 按钮

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public int getMenuGrade() {
        return menuGrade;
    }

    public void setMenuGrade(int menuGrade) {
        this.menuGrade = menuGrade;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MenuManage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", parentId='" + parentId + '\'' +
                ", isDeleted='" + isDeleted + '\'' +
                ", createTime='" + createTime + '\'' +
                ", icon='" + icon + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", sort='" + sort + '\'' +
                ", sessionKey='" + sessionKey + '\'' +
                ", parentName='" + parentName + '\'' +
                ", menuGrade=" + menuGrade +
                '}';
    }
}
