package com.anmi.webapp.entity;

import javax.persistence.*;

@Entity()
@Table(name="roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String role;

    public enum AccountRole {
        ROLE_ADMIN,ROLE_USER,ROLE_MAINTENACE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



}
