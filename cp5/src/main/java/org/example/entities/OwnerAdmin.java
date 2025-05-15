package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "\"OwnerAdmin\"")
public class OwnerAdmin implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Administrator owner;

    @Id
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Administrator admin;

    public Administrator getOwner() {
        return owner;
    }

    public void setOwner(Administrator owner) {
        this.owner = owner;
    }

    public Administrator getAdmin() {
        return admin;
    }

    public void setAdmin(Administrator admin) {
        this.admin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnerAdmin that = (OwnerAdmin) o;
        return Objects.equals(owner, that.owner) && Objects.equals(admin, that.admin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, admin);
    }
}
