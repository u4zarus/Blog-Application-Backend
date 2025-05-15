package org.example.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Embeddable
public class CommentID implements Serializable {
    @Column(name = "post_id")
    private Integer post_id;

    @Column(name = "author_id")
    private Integer author_id;

    @Column(name = "comment_time")
    private Timestamp comment_time;

    public CommentID() {}

    public CommentID(Integer post_id, Integer author_id, Timestamp comment_time) {
        this.post_id = post_id;
        this.author_id = author_id;
        this.comment_time = comment_time;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public Timestamp getComment_time() {
        return comment_time;
    }

    public void setComment_time(Timestamp comment_time) {
        this.comment_time = comment_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentID commentID = (CommentID) o;
        return Objects.equals(post_id, commentID.post_id) && Objects.equals(author_id, commentID.author_id) && Objects.equals(comment_time, commentID.comment_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(post_id, author_id, comment_time);
    }

    @Override
    public String toString() {
        return "CommentID{" +
                "post_id=" + post_id +
                ", author_id=" + author_id +
                ", comment_time=" + comment_time +
                '}';
    }
}
