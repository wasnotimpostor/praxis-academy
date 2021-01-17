package uvuvwevwevwe.onyetenyevwe.ugwemubwem.ossas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uvuvwevwevwe.onyetenyevwe.ugwemubwem.ossas.model.TokoVape;
import uvuvwevwevwe.onyetenyevwe.ugwemubwem.ossas.repository.TokoVapeRepo;

import java.util.List;

@RestController
@RequestMapping("/")
public class VapeController {

    @Autowired
    TokoVapeRepo tokoVapeRepo;

    @GetMapping("/vape")
    @PreAuthorize("hasRole('ADMIN') or hasRole('BUYER')")
    public @ResponseBody
    List<TokoVape> getAllToko() {
        return tokoVapeRepo.findAll();
    }

    @PostMapping("/vape/add")
    @PreAuthorize("hasRole('ADMIN')")
    public TokoVape addVape(@RequestBody TokoVape tokoVape) {
        return tokoVapeRepo.save(tokoVape);
    }

    @PutMapping("/vape/{id}")
    public TokoVape replaceTokoVape(@RequestBody TokoVape newTokoVape, @PathVariable Long id) {
        return tokoVapeRepo.findById(id).map(tokoVape -> {
            tokoVape.setId_barang(newTokoVape.getId_barang());
            tokoVape.setItem(newTokoVape.getItem());
            tokoVape.setPrice(newTokoVape.getPrice());
            tokoVape.setStock(newTokoVape.getStock());
            return tokoVapeRepo.save(tokoVape);
        }).orElseGet(() -> {
            newTokoVape.setId(id);
            return tokoVapeRepo.save(newTokoVape);
        });
    }

    @DeleteMapping("/vape/{id}")
    public void deleteTokoVape(@PathVariable Long id) {
        tokoVapeRepo.deleteById(id);
    }
}