package com.kepo.kemplo.controller;

import java.util.Optional;

import com.kepo.kemplo.model.Rokok;
import com.kepo.kemplo.repository.RokokRepo;

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
@RequestMapping(path = "/rokok")
public class RokokController {
    @Autowired
    private RokokRepo rokokRepo;

    @PostMapping(path = "/")
    public Rokok addRokok(@RequestBody Rokok rokok) {
        return rokokRepo.save(rokok);
    }
    
    @GetMapping(path = "/")
    public Iterable<Rokok> getAll() {
        return rokokRepo.findAll();
    }

    @GetMapping(path = "/{idRokok}")
    public Optional<Rokok> idRokok(@PathVariable Long idRokok) {
        return rokokRepo.findById(idRokok);
    }

    @DeleteMapping(path = "/")
    public void deleteRokok(@PathVariable Long idRokok) {
        rokokRepo.deleteById(idRokok);
    }

    @PutMapping(path = "/{idRokok}")
    public Rokok update(@PathVariable("idRokok") Long idRokok, @RequestBody Rokok newRokok) {
        Rokok rokok = rokokRepo.findById(idRokok).get();
        rokok.setIdRokok(newRokok.getIdRokok());
        return rokokRepo.save(rokok);
    }
}
