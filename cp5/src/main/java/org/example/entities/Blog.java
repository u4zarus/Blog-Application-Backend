package org.example.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "\"Blog\"")
public class Blog {
    @Id
    @Column(name = "blog_id")
    private Integer blog_id;

    @Column(name = "blog_name", unique = true, nullable = false)
    private String blog_name;

    @ManyToMany(mappedBy = "blogs")
    private List<BUser> users;

    public Blog() {}

    public Blog(Integer blog_id, String blog_name, List<BUser> users) {
        this.blog_id = blog_id;
        this.blog_name = blog_name;
        this.users = users;
    }

    public Integer getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(Integer blog_id) {
        this.blog_id = blog_id;
    }

    public String getBlog_name() {
        return blog_name;
    }

    public void setBlog_name(String blog_name) {
        this.blog_name = blog_name;
    }

    public List<BUser> getUsers() {
        return users;
    }

    public void setUsers(List<BUser> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blog blog = (Blog) o;
        return Objects.equals(blog_id, blog.blog_id) && Objects.equals(blog_name, blog.blog_name) && Objects.equals(users, blog.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blog_id, blog_name, users);
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blog_id=" + blog_id +
                ", blog_name='" + blog_name + '\'' +
                ", users=" + users +
                '}';
    }
}
