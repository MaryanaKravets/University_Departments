package edu.project2.university.controller;

import edu.project2.university.dto.SpeakerDTO;
import edu.project2.university.service.SpeakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/speaker")
public class SpeakerController {

    private final SpeakerService service;

    @ResponseBody
    @GetMapping("/averageSalary/{departmentId}")
    public ResponseEntity<String> averageSalaryOfDepartment(@PathVariable(value = "departmentId") Long departmentId) {

        String average = service.averageSalaryOfDepartment(departmentId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(average);
    }

    @ResponseBody
    @GetMapping("/template")
    public List<SpeakerDTO> findSpeakerByTemplate(@RequestParam(name = "temp1") String temp1,
                                                  @RequestParam(name = "temp2") String temp2) {

        return service.findByFirstNameAndLastNameContains(temp1, temp2);

    }

    @ResponseBody
    @GetMapping("/countEmployees/{departmentId}")
    public int countOfLecturerAtDepartment(@PathVariable(value = "departmentId") Long departmentId) {

        return service.getSpeakerCount(departmentId);
    }

    @ResponseBody
    @GetMapping("/stat/{departmentId}")
    public List<String> getStatisticOfDepartment(@PathVariable(value = "departmentId") Long departmentId) {

        return service.statisticOfDepartment(departmentId);
    }
}
