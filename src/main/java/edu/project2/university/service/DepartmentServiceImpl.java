package edu.project2.university.service;

import edu.project2.university.dto.DepartmentDTO;
import edu.project2.university.exception.Message;
import edu.project2.university.exception.NotFoundException;
import edu.project2.university.model.Department;
import edu.project2.university.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService, Message {

    private final DepartmentRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public Long getHeadOfDepartment(Long id) {

        return repository.getHeadOfDepartment(id);
    }

    @Override
    public DepartmentDTO getById(Long id) {
        Department department = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(DEPARTMENT_NOT_FOUND_EXCEPTION_MESSAGE, id)));

        return modelMapper.map(department, DepartmentDTO.class);
    }
}
