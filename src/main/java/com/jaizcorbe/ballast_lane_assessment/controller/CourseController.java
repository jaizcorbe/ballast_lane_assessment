package com.jaizcorbe.ballast_lane_assessment.controller;

import com.jaizcorbe.ballast_lane_assessment.model.Course;
import com.jaizcorbe.ballast_lane_assessment.service.CourseService;
import com.jaizcorbe.ballast_lane_assessment.service.UserAccessValidator;
import com.jaizcorbe.ballast_lane_assessment.service.exception.AccessPermissionException;
import com.jaizcorbe.ballast_lane_assessment.service.exception.BusinessException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/course")
@AllArgsConstructor
public class CourseController {

  private CourseService service;
  private UserAccessValidator userAccessValidator;
  @PostMapping
  public Course createCourse(@Valid @RequestBody Course course, @RequestParam Long userId) {
    try {
      userAccessValidator.isAdmin(userId);
      return service.create(course);
    } catch(AccessPermissionException e) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
    }
    catch(BusinessException e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @GetMapping
  public Iterable<Course> getAllCourses() {
    return this.service.findAll();
  }
}
