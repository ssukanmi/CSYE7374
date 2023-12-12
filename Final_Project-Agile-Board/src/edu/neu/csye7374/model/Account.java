package edu.neu.csye7374.model;

import java.util.Objects;

public class Account {
    private Role role;
    private int id;
    private String username;
    private String password;
    private String displayName;

    public Account(Role role, int id, String username, String password, String displayName) {
        this.role = role;
        this.id = id;
        this.username = username;
        this.password = password;
        this.displayName = displayName;
    }

    public Role getRole() {
        return role;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}