package projects.finalproject.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.finalproject.domain.model.Developer;


public interface DeveloperRepository extends JpaRepository<Developer, Long> {


    boolean existsByDeveloperName(String name);
}
