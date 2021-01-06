package kasus.toko.vapor.repository;

//import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kasus.toko.vapor.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //List<User> findAll();
    Boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
}
