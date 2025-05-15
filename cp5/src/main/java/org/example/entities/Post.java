package org.example.entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "\"Post\"")
public class Post {
    @Id
    @Column(name = "post_id")
    private Integer post_id;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Administrator author;

    @Column(name = "post_title", nullable = false)
    private String post_title;

    @Column(name = "post_content", nullable = false)
    private String post_content;

    @Column(name = "post_time", nullable = false)
    private Time post_time;

    @Column(name = "post_date", nullable = false)
    private Date post_date;

    public Post(Integer post_id, Blog blog, Administrator author, String post_title, String post_content, Time post_time, Date post_date) {
        this.post_id = post_id;
        this.blog = blog;
        this.author = author;
        this.post_title = post_title;
        this.post_content = post_content;
        this.post_time = post_time;
        this.post_date = post_date;
    }

    public Post() {}

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Administrator getAuthor() {
        return author;
    }

    public void setAuthor(Administrator author) {
        this.author = author;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public Time getPost_time() {
        return post_time;
    }

    public void setPost_time(Time post_time) {
        this.post_time = post_time;
    }

    public Date getPost_date() {
        return post_date;
    }

    public void setPost_date(Date post_date) {
        this.post_date = post_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(post_id, post.post_id) && Objects.equals(blog, post.blog) && Objects.equals(author, post.author) && Objects.equals(post_title, post.post_title) && Objects.equals(post_content, post.post_content) && Objects.equals(post_time, post.post_time) && Objects.equals(post_date, post.post_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(post_id, blog, author, post_title, post_content, post_time, post_date);
    }

    @Override
    public String toString() {
        return "Post{" +
                "post_id=" + post_id +
                ", blog=" + blog +
                ", author=" + author +
                ", post_title='" + post_title + '\'' +
                ", post_content='" + post_content + '\'' +
                ", post_time=" + post_time +
                ", post_date=" + post_date +
                '}';
    }
}
