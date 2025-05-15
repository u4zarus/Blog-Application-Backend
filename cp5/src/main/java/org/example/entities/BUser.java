package org.example.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "\"BUser\"")
@Inheritance(strategy = InheritanceType.JOINED)
public class BUser {

    @Id
    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "phone_number", unique = true, nullable = false)
    private String phone_number;

    @Column(name = "first_name", nullable = false)
    private String first_name;

    @Column(name = "last_name", nullable = false)
    private String last_name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private LoginInfo loginInfo;

    @ManyToMany
    @JoinTable(
            name = "\"BlogFollower\"",
            joinColumns = @JoinColumn(name = "follower_id"),
            inverseJoinColumns = @JoinColumn(name = "blog_id")
    )
    private List<Blog> blogs;

    public BUser(Integer userId, String phoneNumber, String firstName, String lastName) {
        this.user_id = userId;
        this.phone_number = phoneNumber;
        this.first_name = firstName;
        this.last_name = lastName;
    }

    public BUser() {}

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public LoginInfo getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BUser bUser = (BUser) o;
        return Objects.equals(user_id, bUser.user_id) && Objects.equals(phone_number, bUser.phone_number) && Objects.equals(first_name, bUser.first_name) && Objects.equals(last_name, bUser.last_name) && Objects.equals(loginInfo, bUser.loginInfo) && Objects.equals(blogs, bUser.blogs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, phone_number, first_name, last_name, loginInfo, blogs);
    }

    @Override
    public String toString() {
        return "BUser{" +
                "user_id=" + user_id +
                ", phone_number='" + phone_number + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", loginInfo=" + loginInfo +
                '}';
    }
}
