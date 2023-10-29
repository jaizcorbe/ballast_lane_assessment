package com.jaizcorbe.ballast_lane_assessment.service.validator;

import com.jaizcorbe.ballast_lane_assessment.model.WorkLog;
import com.jaizcorbe.ballast_lane_assessment.service.exception.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@AllArgsConstructor
public class WorkLogValidator {
  public boolean isValid(WorkLog workLog) throws BusinessException {
    isValidTime(workLog);
    isValidDate(workLog);
    return true;
  }

  public boolean isValidDate(WorkLog workLog) throws BusinessException {
    LocalDate courseEndDate = workLog.getCourseRegistration().getCourse().getEndDate();
    if(workLog.getTaskDate().isAfter(courseEndDate)) {
      throw new BusinessException("WorkLog date must be on course duration");
    }
    return true;
  }

  public boolean isValidTime(WorkLog workLog) throws BusinessException {
    if(workLog.getTaskMinutes() % 30 !=  0) {
      throw new BusinessException("WorkLog time must be in 30 increments");
    }
    return true;
  }
}
