package com.impian.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private com.impian.model.RoleName name;
 
    public Role() {}
 
    public Role(com.impian.model.RoleName name) {
        this.name = name;
    }
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public com.impian.model.RoleName getName() {
        return name;
    }
 
    public void setName(com.impian.model.RoleName name) {
        this.name = name;
    }
}