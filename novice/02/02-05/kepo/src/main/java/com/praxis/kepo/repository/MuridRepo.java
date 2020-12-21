package com.praxis.kepo.repository;

import com.praxis.kepo.model.Murid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public interface MuridRepo extends CrudRepository<Murid, Integer> {
    
}
