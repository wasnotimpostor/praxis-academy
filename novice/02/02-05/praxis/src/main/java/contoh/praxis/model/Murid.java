package contoh.praxis.model;

//import javax.persistance.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
//import Javax.persistence.GenerationType;
import javax.persistence.Id;
import contoh.praxis.model.Bimbel;

@javax.persistence.Entity
@Table(name = "murid")
public class Murid {
    private String nama;
    private String alamat;
    private int id;

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
