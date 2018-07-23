package com.im.coffee.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "orders")
public class Orders {


    private Long id;
    private String status;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Collection<Coffees> coffees;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    @OneToMany(mappedBy = "orders", targetEntity = Coffees.class, fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    public Collection<Coffees> getCoffees() {
        return coffees;
    }

    public void setCoffees(Collection<Coffees> coffees) {
        this.coffees = coffees;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", coffees=" + coffees +
                '}';
    }
}
