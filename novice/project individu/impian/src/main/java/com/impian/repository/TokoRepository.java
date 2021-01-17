package com.impian.repository;

import com.impian.model.Toko;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokoRepository extends JpaRepository<Toko, Long> {
}
