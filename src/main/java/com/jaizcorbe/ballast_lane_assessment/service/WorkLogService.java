package com.jaizcorbe.ballast_lane_assessment.service;

import com.jaizcorbe.ballast_lane_assessment.model.CourseRegistration;
import com.jaizcorbe.ballast_lane_assessment.model.Student;
import com.jaizcorbe.ballast_lane_assessment.model.WorkLog;
import com.jaizcorbe.ballast_lane_assessment.model.WorkLogRequest;
import com.jaizcorbe.ballast_lane_assessment.repository.WorkLogRepository;
import com.jaizcorbe.ballast_lane_assessment.service.exception.BusinessException;
import com.jaizcorbe.ballast_lane_assessment.service.exception.NotFoundException;
import com.jaizcorbe.ballast_lane_assessment.service.validator.WorkLogValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WorkLogService {
  private WorkLogRepository repository;
  private WorkLogValidator validator;

  private StudentService studentService;
  private CourseRegistrationService courseRegistrationService;

  public WorkLog find(Long id) throws NotFoundException {
    return repository.findById(id)
      .orElseThrow(() -> new NotFoundException("Work log not found for id %s".formatted(id)));
  }

  public Iterable<WorkLog> findAllForStudent(Long studentId) {
    return repository.findAllByStudentId(studentId);
  }

  public WorkLog create(WorkLogRequest request) throws BusinessException {
    Student student = studentService.find(request.getStudentId());
    CourseRegistration registration = courseRegistrationService.find(request.getRegistrationId());
    WorkLog workLog = WorkLog.builder()
      .courseRegistration(registration)
      .studentId(student.getId())
      .taskDescription(request.getTaskDescription())
      .taskDate(request.getTaskDate())
      .taskMinutes(request.getTaskMinutes())
      .taskCategory(request.getTaskCategory())
      .build();
    validator.isValid(workLog);
    return repository.save(workLog);
  }

  public WorkLog update(WorkLog workLog) throws BusinessException {
    validator.isValid(workLog);
    return repository.save(workLog);
  }

  public WorkLog delete(Long id) throws NotFoundException {
    WorkLog workLog = find(id);
    repository.delete(workLog);
    return workLog;
  }
}
