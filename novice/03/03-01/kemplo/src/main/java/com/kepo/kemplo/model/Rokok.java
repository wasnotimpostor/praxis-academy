package com.kepo.kemplo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rokok")
public class Rokok {
    @Id
    @GeneratedValue
    public Long idRokok;

    @Column (nullable = false)
    private String namaRokok;

    @OneToOne (mappedBy = "rokok")
    private Kasir kasir;

    public void setNamaRokok(String namaRokok) {
        this.namaRokok = namaRokok;
    }

    public String getNamaRokok() {
        return namaRokok;
    }

    public void setIdRokok(Long idRokok) {
        this.idRokok = idRokok;
    }

    public Long getIdRokok() {
        return idRokok;
    }
}
