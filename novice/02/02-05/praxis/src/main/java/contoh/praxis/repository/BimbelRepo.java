package contoh.praxis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import contoh.praxis.model.Bimbel;

@Repository
public interface BimbelRepo extends JpaRepository {
    List<Bimbel> findAll();
    Bimbel save(Bimbel bimbel);
    Bimbel updateBimbel(int idBimbel, Integer bimbel);
    Optional<Bimbel> findByIdBimbel(Integer idBimbel);
    void deleteByIdBimbel(Integer idBimbel);
    //Bimbel findByIdBimbel(Integer idBimbel);
	void setNamaBimbel(String namaBimbel);
}
