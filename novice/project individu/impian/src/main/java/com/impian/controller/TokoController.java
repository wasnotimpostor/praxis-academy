package com.impian.controller;

import com.impian.model.Toko;
import com.impian.security.services.TokoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kasus")
public class TokoController {

    @Autowired
    private TokoService tokoService;

    @GetMapping("/alltoko")
    public List<Toko> getAllToko() {
        return tokoService.getAllToko();
    }

    @PostMapping("/alltoko/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Toko addToko(@RequestBody Toko toko) {
        return tokoService.addToko(toko);
    }

    @GetMapping("/alltoko/{id}")
    public Toko getToko(@PathVariable Long id) {
        return tokoService.getToko(id);
    }

    @DeleteMapping("/alltoko/{id}")
    public Toko deleteToko(@PathVariable Long id) {
        return tokoService.deleteToko(id);
    }
}
