package contoh.praxis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import contoh.praxis.model.Bimbel;
import contoh.praxis.repository.BimbelRepo;

@RestController
@RequestMapping("/bimbel")
public class BimbelController {

    @Autowired
    public BimbelRepo bimbelRepo;

    @GetMapping("/")
    public @ResponseBody List<Bimbel> getAllBimbel() {
        return bimbelRepo.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Bimbel getByIdBimbel(@PathVariable("id") int idBimbel) {
        return bimbelRepo.findByIdBimbel(idBimbel).get();
    }

    @PostMapping("/")
    public @ResponseBody Bimbel addNewBimbel(@RequestBody Bimbel bimbel) {
        return bimbelRepo.save(bimbel);
    }

    @DeleteMapping("/{id}")
    public String deleteBimbel(@PathVariable("id") int idBimbel) {
        Bimbel bimbel = bimbelRepo.findByIdBimbel(idBimbel).get();
        bimbelRepo.delete(bimbel);
        return "Deleted";
    }

    @PostMapping("/{id}")
    public Bimbel update(@PathVariable("id") int idBimbel, @RequestBody Bimbel newBimbel) {
        Bimbel bimbel = bimbelRepo.findByIdBimbel(idBimbel).get();
        bimbelRepo.setNamaBimbel(newBimbel.getNamaBimbel());
        return bimbelRepo.save(bimbel);
    }
}
