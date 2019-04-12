package gameshop.gameshop.repository;

import gameshop.gameshop.domain.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {

    Role findByAuthority(String authority);
}
