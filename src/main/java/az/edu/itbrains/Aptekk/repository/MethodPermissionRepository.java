package az.edu.itbrains.Aptekk.repository;

import az.edu.itbrains.Aptekk.models.MethodPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MethodPermissionRepository extends JpaRepository<MethodPermission, Long> {
    MethodPermission findByName(String methodName);
}
