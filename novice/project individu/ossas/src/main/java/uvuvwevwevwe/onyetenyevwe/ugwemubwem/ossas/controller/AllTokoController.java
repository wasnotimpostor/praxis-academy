package uvuvwevwevwe.onyetenyevwe.ugwemubwem.ossas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uvuvwevwevwe.onyetenyevwe.ugwemubwem.ossas.model.AllToko;
import uvuvwevwevwe.onyetenyevwe.ugwemubwem.ossas.repository.AllTokoRepo;

import java.util.List;

@RestController
@RequestMapping("ossas")
public class AllTokoController {

    @Autowired
    AllTokoRepo allTokoRepo;

    @GetMapping("/alltoko")
    @PreAuthorize("hasRole('ADMIN')")
    public @ResponseBody
    List<AllToko> getAllToko() {
        return allTokoRepo.findAll();
    }

    @PostMapping("/alltoko/add")
    @PreAuthorize("hasRole('ADMIN')")
    public AllToko add(@RequestBody AllToko allToko) {
        //long count = allTokoRepo.count();
        return allTokoRepo.save(allToko);
    }
}
