package com.jaizcorbe.ballast_lane_assessment.service;

import com.jaizcorbe.ballast_lane_assessment.model.Course;
import com.jaizcorbe.ballast_lane_assessment.model.CourseRegistration;
import com.jaizcorbe.ballast_lane_assessment.model.CourseRegistrationRequest;
import com.jaizcorbe.ballast_lane_assessment.model.Student;
import com.jaizcorbe.ballast_lane_assessment.repository.CourseRegistrationRepository;
import com.jaizcorbe.ballast_lane_assessment.service.exception.BusinessException;
import com.jaizcorbe.ballast_lane_assessment.service.exception.NotFoundException;
import com.jaizcorbe.ballast_lane_assessment.service.validator.CourseRegistrationValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseRegistrationService {
  private StudentService studentService;
  private CourseService courseService;
  private CourseRegistrationRepository repository;
  private CourseRegistrationValidator validator;

  public CourseRegistration find(Long registrationId) throws NotFoundException {
    return repository.findById(registrationId)
      .orElseThrow(() -> new NotFoundException("Course Registration not found for id %s".formatted(registrationId)));
  }
  public CourseRegistration registerCourse(CourseRegistrationRequest registrationRequest) throws BusinessException {
    Course course = courseService.find(registrationRequest.courseId());
    Student student = studentService.find(registrationRequest.studentId());
    CourseRegistration registration = CourseRegistration.builder()
      .student(student)
      .course(course)
      .active(true)
      .build();
    validator.isValid(registration);
    return repository.save(registration);
  }

  public CourseRegistration unregister(Long registrationId) throws NotFoundException {
    CourseRegistration registration = find(registrationId);
    registration.setActive(false);
    return repository.save(registration);
  }

  public List<CourseRegistration> findRegistrations(Student student, boolean active) {
    return repository.findAllByStudentAndActive(student, active);
  }
}
