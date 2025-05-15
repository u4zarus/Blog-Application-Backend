package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "\"AdminBlog\"")
public class AdminBlog implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Administrator administrator;

    @Id
    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminBlog adminBlog = (AdminBlog) o;
        return Objects.equals(administrator, adminBlog.administrator) && Objects.equals(blog, adminBlog.blog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(administrator, blog);
    }
}
