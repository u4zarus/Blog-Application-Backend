package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "\"OwnerBlog\"")
public class OwnerBlog implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Administrator owner;

    @Id
    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;

    public Administrator getOwner() {
        return owner;
    }

    public void setOwner(Administrator owner) {
        this.owner = owner;
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
        OwnerBlog ownerBlog = (OwnerBlog) o;
        return Objects.equals(owner, ownerBlog.owner) && Objects.equals(blog, ownerBlog.blog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, blog);
    }
}
