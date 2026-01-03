package az.edu.itbrains.Aptekk.repository;


import az.edu.itbrains.Aptekk.models.Features;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends JpaRepository<Features, Long> {

}
