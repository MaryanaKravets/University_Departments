package edu.project2.university.repository;

import edu.project2.university.model.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

    @Query(value = "SELECT AVG(salary) AS avg_salary FROM speakers WHERE speakers.speaker_belongs_department_id=?1", nativeQuery = true)
    Double averageSalaryOfDepartment(Long id);

    List<Speaker> findByFirstNameContainingOrLastNameContaining(String temp1, String temp2);

    @Query(value = "SELECT COUNT(speakers) FROM speakers WHERE speakers.speaker_belongs_department_id=?1", nativeQuery = true)
    int getSpeakerCount(Long id);

    @Query(value = "SELECT degree || ': ' || COUNT(degree) FROM speakers WHERE speakers.speaker_belongs_department_id=?1 GROUP BY degree", nativeQuery = true)
    List<String> statisticOfDepartment(Long id);
}
