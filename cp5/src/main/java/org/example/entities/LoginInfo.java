package org.example.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "\"LoginInfo\"")
public class LoginInfo {

    @Id
    @Column(name = "login_id")
    private Integer login_id;

    @Column(name = "e_mail", unique = true, nullable = false)
    private String e_mail;

    @Column(name = "user_password", nullable = false)
    private String user_password;

    public LoginInfo(Integer login_id, String e_mail, String user_password) {
        this.login_id = login_id;
        this.e_mail = e_mail;
        this.user_password = user_password;
    }

    public LoginInfo() {}

    public Integer getLogin_id() {
        return login_id;
    }

    public void setLogin_id(Integer login_id) {
        this.login_id = login_id;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginInfo loginInfo = (LoginInfo) o;
        return Objects.equals(login_id, loginInfo.login_id) && Objects.equals(e_mail, loginInfo.e_mail) && Objects.equals(user_password, loginInfo.user_password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login_id, e_mail, user_password);
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "login_id=" + login_id +
                ", e_mail='" + e_mail + '\'' +
                ", user_password='" + user_password + '\'' +
                '}';
    }
}
