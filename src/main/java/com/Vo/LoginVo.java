package com.Vo;

public class LoginVo {
    private Long telephone;
    private String password;

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

    @Override
    public String toString() {
        return "LoginVo{" +
                "telephone=" + telephone +
                ", password='" + password + '\'' +
                '}';
    }
}
