package ua.com.nix.timeline_proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.nix.timeline_proj.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
