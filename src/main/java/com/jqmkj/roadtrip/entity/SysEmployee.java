package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;

public class SysEmployee extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //用户名
    private String username;

    //邮箱
    private String email;

    //姓名
    private String name;

    //性别
    private String sex;

    //是否管理员
    private Integer isAdmin;

    //部门
    private Long departmentId;

    //手机
    private String phone;

    //IP
    private String ip;

    //登入次数
    private String logins;

    private static final long serialVersionUID = 1L;

    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLogins() {
        return logins;
    }

    public void setLogins(String logins) {
        this.logins = logins;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", email=").append(email);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", isAdmin=").append(isAdmin);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", phone=").append(phone);
        sb.append(", ip=").append(ip);
        sb.append(", logins=").append(logins);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        username("username"),
        email("email"),
        name("name"),
        sex("sex"),
        isAdmin("is_admin"),
        departmentId("department_id"),
        phone("phone"),
        ip("ip"),
        logins("logins"),
        createId("create_id"),
        createTime("create_time"),
        updateId("update_id"),
        updateTime("update_time");

        private final String column;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        Column(String column) {
            this.column = column;
        }

        public String desc() {
            return this.column + " DESC";
        }

        public String asc() {
            return this.column + " ASC";
        }
    }
}