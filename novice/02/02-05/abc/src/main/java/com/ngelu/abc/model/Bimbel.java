package com.ngelu.abc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bimbel")
public class Bimbel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idBimbel;

    private String namaBimbel;
    private String alamatBimbel;

    public void setId(Long idBimbel) {
        this.idBimbel = idBimbel;
    }

    public void setNamaBimbel(String namaBimbel) {
        this.namaBimbel = namaBimbel;
    }

    public void setAlamatBimbel(String alamatBimbel) {
        this.alamatBimbel = alamatBimbel;
    }

    public Long getIdBimbel() {
        return idBimbel;
    }

    public String getNamaBimbel() {
        return namaBimbel;
    }

    public String getAlamatBimbel() {
        return alamatBimbel;
    }
}
