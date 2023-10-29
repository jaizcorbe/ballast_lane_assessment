package com.jaizcorbe.ballast_lane_assessment.controller;

import com.jaizcorbe.ballast_lane_assessment.model.CourseRegistration;
import com.jaizcorbe.ballast_lane_assessment.model.CourseRegistrationRequest;
import com.jaizcorbe.ballast_lane_assessment.service.CourseRegistrationService;
import com.jaizcorbe.ballast_lane_assessment.service.exception.BusinessException;
import com.jaizcorbe.ballast_lane_assessment.service.exception.NotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/course_registration")
@AllArgsConstructor
public class CourseRegistrationController {

  private CourseRegistrationService service;
  @PostMapping
  public CourseRegistration create(@Valid @RequestBody CourseRegistrationRequest registrationRequest) {
    try {
      return service.registerCourse(registrationRequest);
    } catch(BusinessException e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @PutMapping("/{registrationId}/unregister")
  public CourseRegistration unregister(@PathVariable Long registrationId) {
    try {
      return service.unregister(registrationId);
    } catch (NotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }

  }
}
