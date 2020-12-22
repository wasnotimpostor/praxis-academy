package com.kepo.kemplo.controller;

import java.util.Optional;

import com.kepo.kemplo.model.Kasir;
import com.kepo.kemplo.repository.KasirRepo;

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
@RequestMapping (path = "/kemplo")
public class MainController {
    @Autowired
    private KasirRepo kasirRepo;

    @PostMapping(path = "/")
    public Kasir addKasir(@RequestBody Kasir kasir) {
        return kasirRepo.save(kasir);
    }

    @GetMapping(path = "/")
    public Iterable<Kasir> getAll() {
        return kasirRepo.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Kasir> idKasir(@PathVariable Long id) {
        return kasirRepo.findById(id);
    }

    @DeleteMapping(path = "/")
    public void deleteKasir(@PathVariable Long id) {
        kasirRepo.deleteById(id);
    }

    @PutMapping(path = "/{id}")
    public Kasir replaceKasir(@RequestBody Kasir newKasir, @PathVariable Long id) {
        return kasirRepo.findById(id)
        .map(kasir ->{
            kasir.setNamaBarang(newKasir.getNamaBarang());
            //kasir.setId(newKasir.getId());
            kasir.setHargaBarang(newKasir.getHargaBarang());
            return kasirRepo.save(kasir);
        }) .orElseGet(() ->{
            newKasir.setId(id);
            return kasirRepo.save(newKasir);
        });
    }
}
