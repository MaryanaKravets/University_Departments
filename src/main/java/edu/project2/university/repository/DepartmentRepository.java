package edu.project2.university.repository;

import edu.project2.university.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query(value = "SELECT head_of_department_id FROM departments WHERE departments.id=?1", nativeQuery = true)
    Long getHeadOfDepartment(Long id);

    Optional<Department> findById(Long id);
}
