package com.jaizcorbe.ballast_lane_assessment.service;

import com.jaizcorbe.ballast_lane_assessment.model.Course;
import com.jaizcorbe.ballast_lane_assessment.repository.CourseRepository;
import com.jaizcorbe.ballast_lane_assessment.service.exception.BusinessException;
import com.jaizcorbe.ballast_lane_assessment.service.validator.CourseValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseService {
  private CourseRepository repository;
  private CourseValidator validator;
  public Course create(Course course) throws BusinessException {
    validator.isValid(course);
    try {
      return repository.save(course);
    } catch(Exception e) {
      throw new BusinessException("Unexpected error while creating course %s".formatted(course.getName()),e);
    }
  }
}
