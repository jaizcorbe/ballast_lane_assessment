package com.jaizcorbe.ballast_lane_assessment.service;

import com.jaizcorbe.ballast_lane_assessment.model.Student;
import com.jaizcorbe.ballast_lane_assessment.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

  private StudentRepository repository;

  private StudentValidator validator;

  public Optional<Student> find(Long id) {
    return repository.findById(id);
  }
  public Student create(Student student) throws BusinessException {
    try {
      validator.isValid(student);
      return repository.save(student);
    } catch(Exception e) {
      throw new BusinessException("Unexpected error while creating student %s".formatted(student.getEmail()),e);
    }
  }
}
