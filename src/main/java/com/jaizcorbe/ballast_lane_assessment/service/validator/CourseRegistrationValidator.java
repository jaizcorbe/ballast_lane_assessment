package com.jaizcorbe.ballast_lane_assessment.service.validator;

import com.jaizcorbe.ballast_lane_assessment.model.Course;
import com.jaizcorbe.ballast_lane_assessment.model.CourseRegistration;
import com.jaizcorbe.ballast_lane_assessment.repository.CourseRegistrationRepository;
import com.jaizcorbe.ballast_lane_assessment.service.CourseService;
import com.jaizcorbe.ballast_lane_assessment.service.exception.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class CourseRegistrationValidator {

  public static final int MAX_ACTIVE_COURSES = 3;

  private CourseRegistrationRepository repository;

  private CourseService courseService;

  public boolean isValid(CourseRegistration registration) throws BusinessException {
    List<CourseRegistration> activeCourses = repository.findAllByStudentAndActive(registration.getStudent(), true);
    Long courseId = registration.getCourse().getId();
    this.isValidActiveCoursesNumber(activeCourses);
    this.isValidNewCourseRegistration(courseId, activeCourses);
    this.isActiveCourse(courseId);
    return true;
  }

  private boolean isValidNewCourseRegistration(Long courseId, List<CourseRegistration> activeCourses) throws BusinessException {

    Optional<Long> isAlreadyActive = activeCourses.stream()
      .map(CourseRegistration::getCourse)
      .map(Course::getId)
      .filter(activeCourseId -> activeCourseId.equals(courseId))
      .findAny();
    if(isAlreadyActive.isPresent()) {
      throw new BusinessException("Student is already active at the course %s".formatted(courseId));
    }
    return true;
  }

  private boolean isValidActiveCoursesNumber(List<CourseRegistration> activeCourses) throws BusinessException {
    if(activeCourses.size() >= MAX_ACTIVE_COURSES) {
      throw new BusinessException("Student can't register at more than 3 courses at the same time");
    }
    return true;
  }

  private boolean isActiveCourse(Long courseId) throws BusinessException {
    Course course = courseService.find(courseId);
    if(course.isCompleted()) {
      throw new BusinessException("The course %s is already finished".formatted(courseId));
    }
    return true;
  }
}
