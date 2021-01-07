package com.impian.repository;

import java.util.List;

import com.impian.model.Toko1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Toko1Repository extends JpaRepository<Toko1, Long> {
    List<Toko1> findAll();
}
