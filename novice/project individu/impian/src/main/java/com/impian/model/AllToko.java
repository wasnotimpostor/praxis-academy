package com.impian.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "toko")
public class AllToko {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String alamat;

//    @ManyToOne
//    @JoinColumn(name = "id_barang", referencedColumnName = "id_barang", insertable = false, updatable = false)
//    private Barang barang;
//
//    public Barang getBarang() {
//        return barang;
//    }
//
//    public void setBarang(Barang barang) {
//        this.barang = barang;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
