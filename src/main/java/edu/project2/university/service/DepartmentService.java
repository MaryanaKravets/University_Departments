package edu.project2.university.service;

import edu.project2.university.dto.DepartmentDTO;

public interface DepartmentService {

    Long getHeadOfDepartment(Long id);

    DepartmentDTO getById(Long id);
}
