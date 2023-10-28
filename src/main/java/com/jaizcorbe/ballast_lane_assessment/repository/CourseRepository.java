package com.jaizcorbe.ballast_lane_assessment.repository;

import com.jaizcorbe.ballast_lane_assessment.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course, Long> {
  Optional<Course> findByName(String name);
}
