package com.ngelu.abc.controller;

//import java.util.List;
import java.util.Optional;

import com.ngelu.abc.model.Murid;
import com.ngelu.abc.repository.MuridRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/praxis")
public class MainController {
    @Autowired
    private MuridRepo muridRepo;

    @PostMapping(path = "/")
    public Murid addMurid(@RequestBody Murid murid) {
        return muridRepo.save(murid);
    }

    @GetMapping(path = "/")
    public Iterable<Murid> getAll() {
        return muridRepo.findAll();
    }

    @GetMapping(path="/{id}")
    public Optional<Murid> idMurid(@PathVariable Long id){
        return muridRepo.findById(id);
    }
    
    @DeleteMapping(path="/{id}")
    void deleteMurid(@PathVariable Long id){
        muridRepo.deleteById(id);
    }

    @PutMapping(path="/{id}")
    public Murid replaceMurid(@RequestBody Murid newMurid, @PathVariable Long id){
        return muridRepo.findById(id)
        .map(murid->{
            murid.setNama(newMurid.getNama());
            murid.setId(newMurid.getId());
            return muridRepo.save(murid);
        })
        .orElseGet(()->{
            newMurid.setId(id);
           return muridRepo.save(newMurid);
        })
        ;
    }
}
