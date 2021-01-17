package com.impian.security.services;

import com.impian.model.Toko;
import com.impian.repository.TokoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TokoService {

    @Autowired
    private TokoRepository tokoRepository;

    public List<Toko> getAllToko() {
        List<Toko> tokos = new ArrayList<>();
        tokoRepository.findAll().forEach(tokos::add);
        return tokos;
    }

    public Toko getToko(Long id) {
        Toko toko = tokoRepository.findById(id).orElse(null);
        return toko;
    }

    public Toko addToko(Toko toko) {
        tokoRepository.save(toko);
        return toko;
    }

    public Toko updateToko(Long id, Toko toko) {
        tokoRepository.save(toko);
        return toko;
    }

    public Toko deleteToko(Long id) {
        Toko toko = tokoRepository.findById(id).orElse(null);
        tokoRepository.deleteById(id);
        return toko;
    }
}
