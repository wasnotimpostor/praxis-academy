package com.impian.controller;

import com.impian.model.AllToko;
import com.impian.model.Barang;
import com.impian.repository.AllTokoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/kasus")
@RestController
public class AllTokoController {

    @Autowired
    AllTokoRepository allTokoRepository;

    @GetMapping("/alltoko")
    @PreAuthorize("hasRole('ADMIN') or hasRole('BUYER')")
    public @ResponseBody
    List<AllToko> getToko() { return allTokoRepository.findAll(); }

    @PostMapping( "/alltoko/add")
    @PreAuthorize("hasRole('ADMIN')")
    public AllToko addToko(@RequestBody AllToko allToko) {
        return allTokoRepository.save(allToko);
    }

    @GetMapping(path = "alltoko/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('BUYER')")
    public Optional<AllToko> idToko(@PathVariable Long id) {
        return allTokoRepository.findById(id);
    }

    @PutMapping("/alltoko/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public AllToko replace(@RequestBody AllToko newAllToko, @PathVariable Long id) {
        return allTokoRepository.findById(id).map(allToko -> {
            allToko.setAlamat(newAllToko.getAlamat());
            allToko.setName(newAllToko.getName());
            return allTokoRepository.save(allToko);
        }) .orElseGet(() ->{
            newAllToko.setId(id);
            return allTokoRepository.save(newAllToko);
        });
    }
    @DeleteMapping("/alltoko/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteAllToko(@PathVariable Long id) { allTokoRepository.deleteById(id); }
}
