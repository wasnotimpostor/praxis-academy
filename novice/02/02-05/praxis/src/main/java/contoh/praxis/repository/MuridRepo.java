package contoh.praxis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import contoh.praxis.model.Murid;

@Repository
public interface MuridRepo extends CrudRepository<Murid, Integer> {
    
}
