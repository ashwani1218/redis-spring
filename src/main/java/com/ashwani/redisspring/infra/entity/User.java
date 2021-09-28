package com.ashwani.redisspring.infra.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class User implements Serializable {

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "friends")
    private Long friends;

    public User(Long id, String username, Long friends) {
        super();
        this.id = id;
        this.username = username;
        this.friends = friends;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getFriends() {
        return friends;
    }

    public void setFriends(Long friends) {
        this.friends = friends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(friends, user.friends);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, friends);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", friends=" + friends +
                '}';
    }
}
