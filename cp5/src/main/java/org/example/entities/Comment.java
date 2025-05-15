package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "\"Comment\"")
public class Comment implements Serializable {
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "post_id")
//    private Post post;
//
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "author_id")
//    private BUser author;
//
//    @Column(name = "comment_content", nullable = false)
//    private String comment_content;
//
//    @Column(name = "comment_time", nullable = false)
//    private Timestamp comment_time;
//
//    @Column(name = "comment_id", nullable = false, unique = true)
//    private Integer comment_id;

    @EmbeddedId
    private CommentID commentID;

    @ManyToOne
    @MapsId("post_id")
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @MapsId("author_id")
    @JoinColumn(name = "author_id")
    private BUser author;

    @Column(name = "comment_content", nullable = false)
    private String comment_content;

    @Column(name = "comment_time", nullable = false, insertable = false, updatable = false)
    private Timestamp comment_time;

    public Comment(CommentID commentID, Post post, BUser author, String comment_content, Timestamp comment_time) {
        this.commentID = commentID;
        this.post = post;
        this.author = author;
        this.comment_content = comment_content;
        this.comment_time = comment_time;
    }

    public Comment() {}

    public CommentID getCommentID() {
        return commentID;
    }

    public void setCommentID(CommentID commentID) {
        this.commentID = commentID;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public BUser getAuthor() {
        return author;
    }

    public void setAuthor(BUser author) {
        this.author = author;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
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
        Comment comment = (Comment) o;
        return Objects.equals(commentID, comment.commentID) && Objects.equals(post, comment.post) && Objects.equals(author, comment.author) && Objects.equals(comment_content, comment.comment_content) && Objects.equals(comment_time, comment.comment_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentID, post, author, comment_content, comment_time);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentID=" + commentID +
                ", post=" + post +
                ", author=" + author +
                ", comment_content='" + comment_content + '\'' +
                ", comment_time=" + comment_time +
                '}';
    }
}
