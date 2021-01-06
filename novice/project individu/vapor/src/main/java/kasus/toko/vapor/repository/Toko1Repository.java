package kasus.toko.vapor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kasus.toko.vapor.model.Toko1;

@Repository
public interface Toko1Repository extends JpaRepository<Toko1, Long> {
    List<Toko1> findAll();
}
