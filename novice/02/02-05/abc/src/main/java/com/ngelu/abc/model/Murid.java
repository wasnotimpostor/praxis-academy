package com.ngelu.abc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "murid")
public class Murid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nama;
    private String umur;

    public void setId(Long id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUmur(String umur ) {
        this.umur = umur;
    }

    public Long getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }
    public String getUmur() {
        return umur;
    }
}
