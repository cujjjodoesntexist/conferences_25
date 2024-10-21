package org.example.conferences_25;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface conferencesRepository extends JpaRepository<Conferences, Long> {
    @Query("SELECT p FROM Conferences p WHERE CONCAT(p.name, '', p.moderatorFullName, '', p.speakerFullName) LIKE %?1%")
    List<Conferences> search(String keyword);
}
