package com.impian.controller;

import com.impian.model.AllToko;
import com.impian.repository.AllTokoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/kasus")
@RestController
public class AllTokoController {

    @Autowired
    AllTokoRepository allTokoRepository;

    @GetMapping("/alltoko")
    @PreAuthorize("hasRole('ADMIN') or hasRole('BUYER')")
    public @ResponseBody
    List<AllToko> getToko() { return allTokoRepository.findAll(); }
}
