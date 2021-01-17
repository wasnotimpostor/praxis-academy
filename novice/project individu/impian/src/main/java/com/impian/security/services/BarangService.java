package com.impian.security.services;

import java.util.ArrayList;
import java.util.List;

import com.impian.model.Barang;
import com.impian.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarangService {

    @Autowired
    private BarangRepository barangRepository;

    public List<Barang> getAllBarang() {
        List<Barang> barangs = new ArrayList<>();
        barangRepository.findAll().forEach(barangs::add);
        return barangs;
    }

    public Barang getBarang(Long id) {
        Barang barang = barangRepository.findById(id).orElse(null);
        return barang;
    }

    public Barang addBarang(Barang barang) {
        barangRepository.save(barang);
        return barang;
    }

    public Barang updateBarang(Long id, Barang barang) {
        barangRepository.save(barang);
        return barang;
    }

    public Barang deleteBarang(Long id) {
        Barang barang = barangRepository.findById(id).orElse(null);
        barangRepository.deleteById(id);
        return barang;
    }
}