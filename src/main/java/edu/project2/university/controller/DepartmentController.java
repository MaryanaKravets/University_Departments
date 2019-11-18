package edu.project2.university.controller;

import edu.project2.university.dto.DepartmentDTO;
import edu.project2.university.service.DepartmentService;
import edu.project2.university.service.SpeakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService service;
    private final SpeakerService speakerService;

    @ResponseBody
    @GetMapping("/{departmentId}")
    public DepartmentDTO getDepartmentById(@PathVariable(value = "departmentId") Long departmentId) {

        return service.getById(departmentId);
    }

    @ResponseBody
    @GetMapping("/head/{departmentId}")
    public String getHeadOfDepartment(@PathVariable(value = "departmentId") Long departmentId) {
        Long speakerId = service.getHeadOfDepartment(departmentId);

        return "Head of " + service.getById(departmentId).getName() + " department is "
                + speakerService.getById(speakerId).getFirstName()
                + " " + speakerService.getById(speakerId).getLastName();
    }
}
