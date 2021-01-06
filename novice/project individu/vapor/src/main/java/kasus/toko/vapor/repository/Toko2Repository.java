package kasus.toko.vapor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kasus.toko.vapor.model.Toko2;

@Repository
public interface Toko2Repository extends JpaRepository<Toko2, Long> {
    List<Toko2> findAll();
}
