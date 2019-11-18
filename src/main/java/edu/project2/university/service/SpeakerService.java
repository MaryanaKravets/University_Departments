package edu.project2.university.service;

import edu.project2.university.dto.SpeakerDTO;

import java.util.List;

public interface SpeakerService {

    String averageSalaryOfDepartment(Long id);

    List<SpeakerDTO> findByFirstNameAndLastNameContains(String templ1, String templ2);

    int getSpeakerCount(Long id);

    List<String> statisticOfDepartment(Long id);

    SpeakerDTO getById(Long id);
}
