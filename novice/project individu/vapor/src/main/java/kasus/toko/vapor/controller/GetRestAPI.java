package kasus.toko.vapor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kasus.toko.vapor.model.User;
import kasus.toko.vapor.repository.BarangRepository;
import kasus.toko.vapor.repository.Toko1Repository;
import kasus.toko.vapor.repository.Toko2Repository;
import kasus.toko.vapor.repository.UserRepository;

@RestController
@RequestMapping
public class GetRestAPI {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public Toko1Repository toko1Repository;

    @Autowired
    public Toko2Repository toko2Repository;

    @Autowired
    public BarangRepository barangRepository;

    @GetMapping("/kasus/admin/getuser")
    @PreAuthorize("hasRole('ADMIN')")
    public @ResponseBody
    List<User> getAllUser() {
        return userRepository.findAll();
    }
}
