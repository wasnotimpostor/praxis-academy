package com.impian.controller;

import com.impian.model.Distribusi;
import com.impian.security.services.DistribusiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kasus")
public class DistribusiController {

    @Autowired
    private DistribusiService distribusiService;

    @GetMapping("/distribusi")
    public List<Distribusi> getAllDistribusi() {
        return distribusiService.getAllDistribusi();
    }

    @PostMapping("/distribusi/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Distribusi addDistribusi(@RequestBody Distribusi distribusi) {
        return distribusiService.addDistribusi(distribusi);
    }

    @GetMapping("/distribusi/{id}")
    public Distribusi getDistribusi(@PathVariable Long id) {
        return distribusiService.getDistribusi(id);
    }

    @DeleteMapping("/distribusi/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Distribusi deleteDistribusi(Long id) {
        return distribusiService.deleteDistribusi(id);
    }
}