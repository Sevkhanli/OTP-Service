package az.edu.itbrains.Aptekk.repository;

import az.edu.itbrains.Aptekk.models.Cure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CureRepository extends JpaRepository<Cure, Long> {

}
