package edu.project2.university.dto;

import edu.project2.university.model.Degree;
import lombok.Data;

@Data
public class SpeakerDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private Double salary;

    private Degree degree;

}
