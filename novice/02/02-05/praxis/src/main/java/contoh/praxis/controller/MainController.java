package contoh.praxis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import contoh.praxis.model.Murid;
import contoh.praxis.repository.MuridRepo;

@RestController
@RequestMapping("/murid")
public class MainController {
    @Autowired
    public MuridRepo muridRepo;

    @GetMapping
    public @ResponseBody Iterable<Murid> getAllMurid() {
        return muridRepo.findAll();
    }

    @PostMapping
    public @ResponseBody Murid addNewMurid(@RequestBody Murid murid) {
        return muridRepo.save(murid);
    }

    @GetMapping("/{id}")
    // Murid muridById(@PathVariable Integer id) {
    //     return muridRepo.findById(id).orElseThrow() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    // }

    @DeleteMapping("/{id}")
    public void deleteMurid(@PathVariable Integer id) {
        muridRepo.deleteById(id);
    }

    @PutMapping("/{id}")
    Murid updateMurid(@RequestBody Murid newMurid, @PathVariable Integer id){
        return muridRepo.findById(id)
        .map(murid ->{
            murid.setNama(newMurid.getNama());
            murid.setAlamat(newMurid.getAlamat());
            return muridRepo.save(newMurid);
        }).orElseGet(() -> {
            newMurid.setId(id);
            return muridRepo.save(newMurid);
        });
    }
}
