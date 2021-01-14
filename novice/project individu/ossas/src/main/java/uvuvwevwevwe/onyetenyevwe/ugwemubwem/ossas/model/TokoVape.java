package uvuvwevwevwe.onyetenyevwe.ugwemubwem.ossas.model;

import javax.persistence.*;

@Entity
@Table(name = "toko_vape")
public class TokoVape {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long id_toko;

    private Long id_barang;

    private String item;

    private Integer price;

    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "id_toko", referencedColumnName = "id", insertable = false, updatable = false)
    private AllToko allToko;

    public AllToko getAllToko() {
        return allToko;
    }

    public void setAllToko(AllToko allToko) {
        this.allToko = allToko;
    }

    public Long getId_toko() {
        return id_toko;
    }

    public void setId_toko(Long id_toko) {
        this.id_toko = id_toko;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
