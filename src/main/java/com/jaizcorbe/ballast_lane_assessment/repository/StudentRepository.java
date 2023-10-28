package com.jaizcorbe.ballast_lane_assessment.repository;

import com.jaizcorbe.ballast_lane_assessment.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Long> {
  Optional<Student> findByEmail(String email);
}
