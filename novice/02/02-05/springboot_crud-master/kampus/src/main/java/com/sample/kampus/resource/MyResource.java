package com.sample.kampus.resource;

import com.sample.kampus.model.BioMahasiswa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyResource extends JpaRepository<BioMahasiswa ,String> {

}
