package az.edu.itbrains.Aptekk.repository;

import az.edu.itbrains.Aptekk.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}