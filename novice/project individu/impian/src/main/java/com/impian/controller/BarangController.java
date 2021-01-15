package com.impian.controller;

import com.impian.model.Barang;
import com.impian.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kasus")
public class BarangController {

    @Autowired
    BarangRepository barangRepository;

    @GetMapping("/barang")
    @PreAuthorize("hasRole('ADMIN')")
    public @ResponseBody
    List<Barang> getAllBarang() {
        return barangRepository.findAll();
    }

    @PostMapping( "/add-barang")
    @PreAuthorize("hasRole('ADMIN')")
    public Barang add(@RequestBody Barang barang) {
        return barangRepository.save(barang);
    }

    @PutMapping("/barang/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Barang replaceBarang(@RequestBody Barang newBarang, @PathVariable Long id) {
        return barangRepository.findById(id).map(barang -> {
            barang.setItem(newBarang.getItem());
            barang.setPrice(newBarang.getPrice());
            barang.setStock(newBarang.getStock());
            return barangRepository.save(barang);
        }) .orElseGet(() ->{
            newBarang.setId(id);
            return barangRepository.save(newBarang);
        });
    }

    @DeleteMapping("/barang/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteBarang(@PathVariable Long id) {
        barangRepository.deleteById(id);
    }
}
