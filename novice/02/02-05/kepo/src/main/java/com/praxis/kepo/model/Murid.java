package com.praxis.kepo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "murid")
public class Murid {
    @Id
    private  Integer id;
    private String nama;
    
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }
}
