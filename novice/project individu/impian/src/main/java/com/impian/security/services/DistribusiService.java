package com.impian.security.services;

import com.impian.model.Distribusi;
import com.impian.repository.DistribusiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistribusiService {

    @Autowired
    private DistribusiRepository distribusiRepository;

    public List<Distribusi> getAllDistribusi() {
        List<Distribusi> distribusis = new ArrayList<>();
        distribusiRepository.findAll().forEach(distribusis::add);
        return distribusis;
    }

    public Distribusi getDistribusi(Long id) {
        Distribusi distribusi = distribusiRepository.findById(id).orElse(null);
        return distribusi;
    }

    public Distribusi addDistribusi(Distribusi distribusi) {
        distribusiRepository.save(distribusi);
        return distribusi;
    }

    public Distribusi updateDistribusi(Long id, Distribusi distribusi) {
        distribusiRepository.save(distribusi);
        return distribusi;
    }

    public Distribusi deleteDistribusi(Long id) {
        Distribusi distribusi = distribusiRepository.findById(id).orElse(null);
        distribusiRepository.deleteById(id);
        return distribusi;
    }
}
