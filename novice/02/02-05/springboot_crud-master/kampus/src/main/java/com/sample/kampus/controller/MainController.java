package com.sample.kampus.controller;

import java.lang.reflect.Array;
import java.util.Optional;

import com.sample.kampus.model.BioMahasiswa;
import com.sample.kampus.resource.MyResource;

import org.aspectj.weaver.ast.Literal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

//import antlr.collections.List;

@RestController
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private MyResource myResource;
    //get, post, get all, get id, post, update

    
    @PostMapping(path="/")
    public BioMahasiswa addBioMahasiswa(@RequestBody BioMahasiswa bioMahasiswa){
        return myResource.save(bioMahasiswa);
    }

    @GetMapping(path="/")//menampilkan iterasi
    public java.util.List<BioMahasiswa> get_all() {
        return myResource.findAll();
    }

    @GetMapping(path="/{nim}")//tipe bio mahasiswaa
    public Optional<BioMahasiswa> nimBioMahasiswa(@PathVariable String nim){
        return myResource.findById(nim);
    }
    
    @DeleteMapping(path="/{nim}")//tidak menampilkan apapun
    void deleteBioMahasiswa(@PathVariable String nim){
        myResource.deleteById(nim);
    }

    @PutMapping(path="/{nim}")//tipe biomahasisa
    public BioMahasiswa replaceBioMahasiswa(@RequestBody BioMahasiswa newbioMahasiswa, @PathVariable String nim){
        return myResource.findById(nim)
        .map(bioMahasiswa->{
            bioMahasiswa.setNama(newbioMahasiswa.getNama());
            bioMahasiswa.setNim(newbioMahasiswa.getNim());
            return myResource.save(bioMahasiswa);
        })
        .orElseGet(()->{
            newbioMahasiswa.setNim(nim);
           return myResource.save(newbioMahasiswa);
        })
        ;
        
    }




}
