package com.koplak.hoax.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
    @Id @GeneratedValue
    private Long idRole;

    @Column
    private String namaRole;

    public void setId(Long idRole) {
        this.idRole = idRole;
    }

    public void setRole(String namaRole) {
        this.namaRole = namaRole;
    }

    public Long getIdRole() {
        return idRole;
    }

    public String getNamaRole() {
        return namaRole;
    }
}
