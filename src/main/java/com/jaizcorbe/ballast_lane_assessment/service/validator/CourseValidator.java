package com.jaizcorbe.ballast_lane_assessment.service.validator;

import com.jaizcorbe.ballast_lane_assessment.model.Course;
import com.jaizcorbe.ballast_lane_assessment.repository.CourseRepository;
import com.jaizcorbe.ballast_lane_assessment.service.exception.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class CourseValidator {
  private CourseRepository repository;

  public boolean isValid(Course course) throws BusinessException {
    Optional<Course> courseOpt = repository.findByName(course.getName());
    if(courseOpt.isPresent()) {
      throw new BusinessException("Course already exists for the name %s".formatted(course.getName()));
    }
    return true;
  }
}
