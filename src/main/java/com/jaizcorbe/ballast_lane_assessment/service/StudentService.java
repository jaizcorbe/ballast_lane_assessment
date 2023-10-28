package com.jaizcorbe.ballast_lane_assessment.service;

import com.jaizcorbe.ballast_lane_assessment.model.Student;
import com.jaizcorbe.ballast_lane_assessment.repository.StudentRepository;
import com.jaizcorbe.ballast_lane_assessment.service.exception.BusinessException;
import com.jaizcorbe.ballast_lane_assessment.service.exception.NotFoundException;
import com.jaizcorbe.ballast_lane_assessment.service.validator.StudentValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {

  private StudentRepository repository;

  private StudentValidator validator;

  public Student find(Long id) throws NotFoundException {
    return repository.findById(id)
      .orElseThrow(() -> new NotFoundException("No Student found for id: %s".formatted(id)));
  }
  public Student create(Student student) throws BusinessException {
    validator.isValid(student);
    try {
      return repository.save(student);
    } catch(Exception e) {
      throw new BusinessException("Unexpected error while creating student %s".formatted(student.getEmail()),e);
    }
  }
}
