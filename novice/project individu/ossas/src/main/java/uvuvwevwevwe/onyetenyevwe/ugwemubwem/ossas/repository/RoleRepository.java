package uvuvwevwevwe.onyetenyevwe.ugwemubwem.ossas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uvuvwevwevwe.onyetenyevwe.ugwemubwem.ossas.model.Role;
import uvuvwevwevwe.onyetenyevwe.ugwemubwem.ossas.model.RoleName;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
