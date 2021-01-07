package com.impian.repository;

import java.util.List;

import com.impian.model.Toko2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Toko2Repository extends JpaRepository<Toko2, Long> {
    List<Toko2> findAll();
}
