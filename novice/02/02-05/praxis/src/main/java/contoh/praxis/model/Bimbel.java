package contoh.praxis.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="bimbel")
public class Bimbel {
    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO);
    private int idBimbel;
    private String namaBimbel;

    public int getIdBimbel() {
        return idBimbel;
    }

    public void setIdBimbel(int idBimbel) {
        this.idBimbel = idBimbel;
    }

    public String getNamaBimbel() {
        return namaBimbel;
    }

    public void setNamaBimbel(String namaBimbel) {
        this.namaBimbel = namaBimbel;
    }
}
