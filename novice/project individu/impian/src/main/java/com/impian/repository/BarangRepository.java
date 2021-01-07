package com.impian.repository;

import java.util.List;

import com.impian.model.Barang;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarangRepository extends JpaRepository<Barang, Long> {
    List<Barang> findAll();
}
