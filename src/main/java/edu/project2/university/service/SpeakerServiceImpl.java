package edu.project2.university.service;

import edu.project2.university.dto.SpeakerDTO;
import edu.project2.university.exception.Message;
import edu.project2.university.exception.NotFoundException;
import edu.project2.university.model.Speaker;
import edu.project2.university.repository.SpeakerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpeakerServiceImpl implements SpeakerService, Message {

    private final SpeakerRepository repository;
    private final ModelMapper modelMapper;
    private final DepartmentService service;

    @Override
    public String averageSalaryOfDepartment(Long id) {
        Double average = repository.averageSalaryOfDepartment(id);

        return "The average salary of " + service.getById(id).getName() + " is " + average;
    }

    @Override
    public List<SpeakerDTO> findByFirstNameAndLastNameContains(String templ1, String templ2) {
        List<Speaker> speakerList = repository.findByFirstNameContainingOrLastNameContaining(templ1, templ2);

        return speakerList.stream()
                .map(l -> (modelMapper.map(l, SpeakerDTO.class)))
                .collect(Collectors.toList());

    }

    @Override
    public int getSpeakerCount(Long id) {
        return repository.getSpeakerCount(id);
    }

    @Override
    public List<String> statisticOfDepartment(Long id) {
        return repository.statisticOfDepartment(id);
    }

    @Override
    public SpeakerDTO getById(Long id) {
        Speaker speaker = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(LECTOR_NOT_FOUND_EXCEPTION_MESSAGE, id)));

        return modelMapper.map(speaker, SpeakerDTO.class);
    }
}
