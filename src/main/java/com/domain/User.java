package com.domain;

import java.util.Date;

public class User {
    private Long telephone;
    private String password;
    private String name;
    private String company;
    private String email;
    private String qq;
    private String salt;
    private Date registerDate;
    private Date lastLoginDate;
    private Integer loginCount;
    private int status;

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "telephone=" + telephone +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                ", salt='" + salt + '\'' +
                ", registerDate=" + registerDate +
                ", lastLoginDate=" + lastLoginDate +
                ", loginCount=" + loginCount +
                ", status=" + status +
                '}';
    }
}
