package kasus.toko.vapor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kasus.toko.vapor.model.Barang;

@Repository
public interface BarangRepository extends JpaRepository<Barang, Long> {
    
}
