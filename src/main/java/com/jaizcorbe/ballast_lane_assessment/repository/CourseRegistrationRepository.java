package com.jaizcorbe.ballast_lane_assessment.repository;

import com.jaizcorbe.ballast_lane_assessment.model.CourseRegistration;
import com.jaizcorbe.ballast_lane_assessment.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRegistrationRepository extends CrudRepository<CourseRegistration, Long> {
  List<CourseRegistration> findAllByStudentAndActive(Student student, boolean active);
}
