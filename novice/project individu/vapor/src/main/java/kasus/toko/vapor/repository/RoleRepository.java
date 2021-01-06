package kasus.toko.vapor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kasus.toko.vapor.model.Role;
import kasus.toko.vapor.model.NamaRole;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByNama(NamaRole namaRole);
}
