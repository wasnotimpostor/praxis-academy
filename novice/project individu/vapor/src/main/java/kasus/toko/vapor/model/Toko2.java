package kasus.toko.vapor.model;

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
    @UniqueConstraint(columnNames = {"id"}),
    @UniqueConstraint(columnNames = {"id_barang"})
})
public class Toko2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @NotBlank
    // private Long idBarang;

    @NotBlank
    private String alamat;

    @ManyToOne
    @JoinColumn(name = "id_barang", referencedColumnName = "id", insertable = false, updatable = false)
    private Barang barang;
    
    private Long id_barang;

    // public Long getIdBarang() {
    //     return idBarang;
    // }

    // public void setIdBarang(Long idBarang) {
    //     this.idBarang = idBarang;
    // }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Long getId_barang() {
        return id_barang;
    }

    public void setId_barang(Long id_barang) {
        this.id_barang = id_barang;
    }
}
