package com.impian.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "toko", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"})
})
public class Toko {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_toko;

    private Long id_barang;

    private String name;

    private String alamat;

    @ManyToOne
    @JoinColumn(name = "id_barang", referencedColumnName = "id_barang", insertable = false, updatable = false)
    private Barang barang;

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public Long getId_toko() {
        return id_toko;
    }

    public void setId_toko(Long id_toko) {
        this.id_toko = id_toko;
    }

    public Long getId_barang() {
        return id_barang;
    }

    public void setId_barang(Long id_barang) {
        this.id_barang = id_barang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
