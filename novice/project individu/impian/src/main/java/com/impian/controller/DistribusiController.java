package com.impian.controller;

import com.impian.model.Distribusi;
import com.impian.repository.DistribusiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kasus")
public class DistribusiController {

    @Autowired
    DistribusiRepository distribusiRepository;

    @GetMapping("/distribusi")
    @PreAuthorize("hasRole('ADMIN')")
    public @ResponseBody
    List<Distribusi> getDistribusi() {
        return distribusiRepository.findAll();
    }

    @PostMapping("/distribusi/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Distribusi addDistribusi(@RequestBody Distribusi distribusi) {
        return distribusiRepository.save(distribusi);
    }
}
