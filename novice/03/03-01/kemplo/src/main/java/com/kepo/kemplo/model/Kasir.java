package com.kepo.kemplo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "kasir")
public class Kasir {
    @Id @GeneratedValue
    private Long id;

    @Column
    private String namaBarang;

    @Column
    private Integer hargaBarang;

    @OneToOne
    @JoinColumn(name = "rokok_idRokok")
    private Rokok rokok;

    public void setNamaBarang(final String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setHargaBarang(final Integer hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public Integer getHargaBarang() {
        return hargaBarang;
    }

    public void setRokok(Rokok A) {
        this.rokok = A;
    }

    public Rokok getRokok() {
        return this.rokok;
    }
}
