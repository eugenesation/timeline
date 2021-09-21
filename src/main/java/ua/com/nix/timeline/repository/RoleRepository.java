package ua.com.nix.timeline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.nix.timeline.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
