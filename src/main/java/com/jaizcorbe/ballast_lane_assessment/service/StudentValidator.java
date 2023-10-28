package com.jaizcorbe.ballast_lane_assessment.service;

import com.jaizcorbe.ballast_lane_assessment.model.Student;
import com.jaizcorbe.ballast_lane_assessment.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class StudentValidator {

  private StudentRepository repository;
  public boolean isValid(Student student) throws BusinessException {
    isValidAge(student);
    isUniqueEmail(student);
    return true;
  }

  private boolean isUniqueEmail(Student student) throws BusinessException {
    Optional<Student> studentOpt = repository.findByEmail(student.getEmail());
    if(studentOpt.isPresent()) {
      throw new BusinessException("Already exists a Student for email %s".formatted(student.getEmail()));
    }
    return true;
  }

  private boolean isValidAge(Student student) throws BusinessException {
    if(student.getAge() < 16) {
      throw new BusinessException("Invalid age for Student %s".formatted(student.getEmail()));
    }
    return true;
  }
}
