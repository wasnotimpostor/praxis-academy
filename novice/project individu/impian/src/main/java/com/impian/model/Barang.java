package com.impian.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "barang")
public class Barang {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_barang;

    @NotBlank
    private String item;

    @NotBlank
    private Double price;

    @NotBlank
    private Integer stock;

    public Long getId_barang() {
        return id_barang;
    }

    public void setId_barang(Long id_barang) {
        this.id_barang = id_barang;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
