package com.manage.model.user;

public class UserDetailsList {
    private String  id;

    private int type;


    /**
     * 名称
     */

    private String name;
    /**
     * 新手
     */
    private String novice;
    /**
     * 活期
     */
    private String current;
    /**
     * 灵活
     */
    private String regular;
    /**
     * 安心三月
     */
    private String anXinMarch;
    /**
     * 安心六月
     */
    private String anXinJune;
    /**
     * 总计
     */
    private String totle;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTotle() {
        return totle;
    }

    public void setTotle(String totle) {
        this.totle = totle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNovice() {
        return novice;
    }

    public void setNovice(String novice) {
        this.novice = novice;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public String getAnXinMarch() {
        return anXinMarch;
    }

    public void setAnXinMarch(String anXinMarch) {
        this.anXinMarch = anXinMarch;
    }

    public String getAnXinJune() {
        return anXinJune;
    }

    public void setAnXinJune(String anXinJune) {
        this.anXinJune = anXinJune;
    }

    public UserDetailsList(String name, String novice, String current, String regular, String anXinMarch, String anXinJune, String totle) {
        this.name = name;
        this.novice = novice;
        this.current = current;
        this.regular = regular;
        this.anXinMarch = anXinMarch;
        this.anXinJune = anXinJune;
        this.totle = totle;
    }

    public UserDetailsList(String id, int type) {
        this.id = id;
        this.type = type;
    }

    public UserDetailsList() {
    }

    @Override
    public String toString() {
        return "UserDetailsList{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", novice='" + novice + '\'' +
                ", current='" + current + '\'' +
                ", regular='" + regular + '\'' +
                ", anXinMarch='" + anXinMarch + '\'' +
                ", anXinJune='" + anXinJune + '\'' +
                ", totle='" + totle + '\'' +
                '}';
    }


}
