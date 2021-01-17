package com.impian.controller;

import java.util.List;

import com.impian.model.Barang;
import com.impian.security.services.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kasus")
public class BarangController {

    @Autowired
    private BarangService barangService;

    @GetMapping("/barang")
    public List<Barang> getAllBarang() {
        return barangService.getAllBarang();
    }

    @PostMapping("/barang/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Barang addBarang(@RequestBody Barang barang) {
        return barangService.addBarang(barang);
    }

    @GetMapping("/barang/{id}")
    public Barang getBarang(@PathVariable Long id) {
        return barangService.getBarang(id);
    }

    @PutMapping("/barang/{id}/w/{quantity}")
    @PreAuthorize("hasRole('ADMIN')")
    public Barang withdrawBarang(@PathVariable Long id, String quantity) {
        Barang barang = barangService.getBarang(id);
        String currQuantity = barang.getStock();
        int newQuantity = Integer.parseInt(currQuantity) - Integer.parseInt(quantity);
        if(newQuantity < 1) {
            System.out.println("new quantity negatif" + newQuantity + "jadi gak bisa withdraw");
            return barang;
        }
        barang.setStock(String.valueOf(newQuantity));
        return barangService.updateBarang(id, barang);
    }

    @PutMapping("/barang/{id}/d/{quantity}")
    @PreAuthorize("hasRole('ADMIN')")
    public Barang depositBarang(@PathVariable Long id, @PathVariable String quantity) {
        Barang barang = barangService.getBarang(id);
        String currQuantity = barang.getStock();
        int newQuantity = Integer.parseInt(currQuantity) + Integer.parseInt(quantity);
        barang.setStock(String.valueOf(newQuantity));
        return barangService.updateBarang(id, barang);
    }

    @DeleteMapping("/barang/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Barang deleteBarang(@PathVariable Long id) {
        return barangService.deleteBarang(id);
    }
}