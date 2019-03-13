package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;

public class SysUser extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //用户名
    private String username;

    //密码
    private String password;

    //昵称
    private String nickname;

    //邮箱
    private String email;

    //姓名
    private String name;

    //性别 0->未知；1->男；2->女
    private String sex;

    //是否锁定
    private Integer isLock;

    //手机
    private String phone;

    //IP
    private String ip;

    //所做城市
    private String city;

    //职业
    private String job;

    //生日 yyyy-MM-dd
    private String birthday;

    //登入次数
    private String logins;

    //个性签名
    private String personalizedSignature;

    //积分
    private Integer score;

    //历史积分数量
    private Integer historyScore;

    //成长值
    private Integer growth;

    //用户-会员等级ID
    private Long userLevelId;

    //头像
    private String icon;

    //帐号启用状态:0->禁用；1->启用
    private Integer userStatus;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public Integer getIsLock() {
        return isLock;
    }

    public void setIsLock(Integer isLock) {
        this.isLock = isLock;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getLogins() {
        return logins;
    }

    public void setLogins(String logins) {
        this.logins = logins;
    }

    public String getPersonalizedSignature() {
        return personalizedSignature;
    }

    public void setPersonalizedSignature(String personalizedSignature) {
        this.personalizedSignature = personalizedSignature;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getHistoryScore() {
        return historyScore;
    }

    public void setHistoryScore(Integer historyScore) {
        this.historyScore = historyScore;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    public Long getUserLevelId() {
        return userLevelId;
    }

    public void setUserLevelId(Long userLevelId) {
        this.userLevelId = userLevelId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", nickname=").append(nickname);
        sb.append(", email=").append(email);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", isLock=").append(isLock);
        sb.append(", phone=").append(phone);
        sb.append(", ip=").append(ip);
        sb.append(", city=").append(city);
        sb.append(", job=").append(job);
        sb.append(", birthday=").append(birthday);
        sb.append(", logins=").append(logins);
        sb.append(", personalizedSignature=").append(personalizedSignature);
        sb.append(", score=").append(score);
        sb.append(", historyScore=").append(historyScore);
        sb.append(", growth=").append(growth);
        sb.append(", userLevelId=").append(userLevelId);
        sb.append(", icon=").append(icon);
        sb.append(", userStatus=").append(userStatus);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        username("username"),
        password("password"),
        nickname("nickname"),
        email("email"),
        name("name"),
        sex("sex"),
        isLock("is_lock"),
        phone("phone"),
        ip("ip"),
        city("city"),
        job("job"),
        birthday("birthday"),
        logins("logins"),
        personalizedSignature("personalized_signature"),
        score("score"),
        historyScore("history_score"),
        growth("growth"),
        userLevelId("user_level_id"),
        icon("icon"),
        userStatus("user_status"),
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