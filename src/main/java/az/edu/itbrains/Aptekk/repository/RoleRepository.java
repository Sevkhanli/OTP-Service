package az.edu.itbrains.Aptekk.repository;


import az.edu.itbrains.Aptekk.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
