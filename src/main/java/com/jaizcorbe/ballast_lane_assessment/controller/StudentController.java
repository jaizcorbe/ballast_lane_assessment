package com.jaizcorbe.ballast_lane_assessment.controller;

import com.jaizcorbe.ballast_lane_assessment.model.Student;
import com.jaizcorbe.ballast_lane_assessment.service.exception.BusinessException;
import com.jaizcorbe.ballast_lane_assessment.service.StudentService;
import com.jaizcorbe.ballast_lane_assessment.service.exception.NotFoundException;
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
      student.setAdmin(false);
      return service.create(student);
    } catch(BusinessException e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
    }
  }

  @GetMapping("/{studentId}")
  public Student getStudent(@PathVariable Long studentId) throws ResponseStatusException {
    try {
      return service.find(studentId);
    } catch (NotFoundException e) {
      throw new ResponseStatusException(
        HttpStatus.NOT_FOUND, e.getMessage());
    }
  }
}
