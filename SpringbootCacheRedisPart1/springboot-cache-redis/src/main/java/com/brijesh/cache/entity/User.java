package com.brijesh.cache.entity;


import javax.persistence.*;

@Entity
@Table(name="user_table")
public class User {

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    @Column(name = "id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="followers")
    private long followers;

    public User() {
    }

    public User(String name, long followers) {
        this.name = name;
        this.followers = followers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getFollowers() {
        return followers;
    }

    public void setFollowers(long followers) {
        this.followers = followers;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", followers=" + followers +
                '}';
    }
}
