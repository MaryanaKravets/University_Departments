package edu.project2.university.dto;

import edu.project2.university.model.DepartmentName;
import lombok.Data;

@Data
public class DepartmentDTO {

    private Long id;

    private DepartmentName name;
}
