package com.praxis.kepo.controller;

import java.util.List;
import java.util.Optional;

import com.praxis.kepo.model.Murid;
import com.praxis.kepo.repository.MuridRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/praxis")
public class MainController {
    @Autowired
    private MuridRepo muridRepo;
    
    @GetMapping
    public @ResponseBody Iterable<Murid> getAllMurid(){
        return muridRepo.findAll();
    }

    @PostMapping(path = "/")
    public Murid addMurid(@RequestBody Murid murid) {
        return muridRepo.save(murid);
    }

    // @GetMapping(path = "/") // menampilkan iterasi
    // public List<Murid> getAll() {
    //     return (List<Murid>) muridRepo.findAll();
    

    // @GetMapping(path = "/") // untuk menampilkan id murid
    // public Optional<Murid> idMurid(@PathVariable Integer id) {
    //     return muridRepo.findAllById(id);
    // }

    // @DeleteMapping(path = "/{id}") // menghapus id murid
    // public void deleteMurid(@PathVariable Integer id) {
    //     muridRepo.deleteById(id);
    // }

    // @PutMapping(path = "/update/{id}")
    // public Murid replaceMurid(@RequestBody Murid newMurid, @PathVariable Integer id) {
    //     return muridRepo.findById(id)
    //     .map(murid -> {
    //         murid.setId(newMurid.getId());
    //         murid.setNama(newMurid.getNama());
    //         return muridRepo.save(murid);
    //     }).orElseGet(() -> {
    //         newMurid.setId(id);
    //         return muridRepo.save(newMurid);
    //     });
    // }
}
