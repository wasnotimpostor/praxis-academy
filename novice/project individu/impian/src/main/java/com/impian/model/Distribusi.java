package com.impian.model;

import javax.persistence.*;

@Entity
@Table(name = "distribusi")
public class Distribusi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_distribusi;

    private Long id_toko;

    private Long id_barang;

    @ManyToOne
    @JoinColumn(name = "id_toko", referencedColumnName = "id", insertable = false, updatable = false)
    private AllToko allToko;

    @ManyToOne
    @JoinColumn(name = "id_barang", referencedColumnName = "id", insertable = false, updatable = false)
    private Barang barang;

    public AllToko getAllToko() {
        return allToko;
    }

    public void setAllToko(AllToko allToko) {
        this.allToko = allToko;
    }

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

    public Long getId_distribusi() {
        return id_distribusi;
    }

    public void setId_distribusi(Long id_distribusi) {
        this.id_distribusi = id_distribusi;
    }
}
