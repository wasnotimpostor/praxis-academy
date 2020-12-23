package com.koplak.hoax.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Column
    private Long id;

    @Column
    private Long idRole;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;
    
    @ManyToOne   
    @JoinColumn(name = "idRole", referencedColumnName = "idRole", insertable = false, updatable = false)
    private Role role;

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public Long getId() {
        return id;
    }

    public Long getIdRole() {
        return idRole;
    }
}
