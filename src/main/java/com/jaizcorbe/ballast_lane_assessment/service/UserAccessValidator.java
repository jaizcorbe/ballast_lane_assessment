package com.jaizcorbe.ballast_lane_assessment.service;

import com.jaizcorbe.ballast_lane_assessment.model.Student;
import com.jaizcorbe.ballast_lane_assessment.service.exception.AccessPermissionException;
import com.jaizcorbe.ballast_lane_assessment.service.exception.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserAccessValidator {

  private StudentService studentService;

  public boolean isAdmin(Long userId) throws BusinessException {
    Student student = studentService.find(userId);
    if(!student.isAdmin()) {
      throw new AccessPermissionException("User %s is not admin");
    }
    return true;
  }
}
