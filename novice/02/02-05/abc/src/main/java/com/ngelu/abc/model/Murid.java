package com.ngelu.abc.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "murid")
public class Murid {
    @Id
    private Long id;
    private String nama;

    public void setId(Long id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Long getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }
}
