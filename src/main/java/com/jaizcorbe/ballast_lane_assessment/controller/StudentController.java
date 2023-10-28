package com.jaizcorbe.ballast_lane_assessment.controller;

import com.jaizcorbe.ballast_lane_assessment.model.Student;
import com.jaizcorbe.ballast_lane_assessment.service.BusinessException;
import com.jaizcorbe.ballast_lane_assessment.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/student")
@AllArgsConstructor
public class StudentController {

  private StudentService service;

  @PostMapping
  public Student createUser(@Valid @RequestBody Student student) {
    try {
      return service.create(student);
    } catch(BusinessException e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
    }
  }

  @GetMapping("/{studentId}")
  public Student getStudent(@PathVariable Long studentId) throws ResponseStatusException {
    return service.find(studentId)
      .orElseThrow(() -> new ResponseStatusException(
        HttpStatus.NOT_FOUND,
        "No student found for id %s".formatted(studentId)));
  }
}
