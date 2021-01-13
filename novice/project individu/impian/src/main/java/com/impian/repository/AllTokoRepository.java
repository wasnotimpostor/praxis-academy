package com.impian.repository;

import com.impian.model.AllToko;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllTokoRepository extends JpaRepository<AllToko, Long> {
}
