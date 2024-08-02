package com.gymbuddy.InstaApi.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Set;
import java.util.HashSet;

@Entity
public class Roles {
    @Id
    @GeneratedValue
    private long id;

    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<Users> users = new HashSet<>();

    public Roles(String role, Set<Users> users) {
        this.role = role;
        this.users = users;
    }

    public Roles() {

    }

    public long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }
}
