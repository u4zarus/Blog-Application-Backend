package org.example.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "\"Administrator\"")
public class Administrator {
    @Id
    @Column(name = "admin_id")
    private Integer admin_id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private BUser user;

    public Administrator() {}

    public Administrator(Integer admin_id, BUser user) {
        this.admin_id = admin_id;
        this.user = user;
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public BUser getUser() {
        return user;
    }

    public void setUser(BUser user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrator that = (Administrator) o;
        return Objects.equals(admin_id, that.admin_id) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(admin_id, user);
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "admin_id=" + admin_id +
                ", user=" + user +
                '}';
    }
}
