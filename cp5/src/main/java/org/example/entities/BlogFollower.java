package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "\"BlogFollower\"")
public class BlogFollower implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "follower_id")
    private BUser follower;

    @Id
    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;

    public BUser getFollower() {
        return follower;
    }

    public void setFollower(BUser follower) {
        this.follower = follower;
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
        BlogFollower that = (BlogFollower) o;
        return Objects.equals(follower, that.follower) && Objects.equals(blog, that.blog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(follower, blog);
    }
}
