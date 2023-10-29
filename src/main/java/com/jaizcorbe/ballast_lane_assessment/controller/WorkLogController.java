package com.jaizcorbe.ballast_lane_assessment.controller;


import com.jaizcorbe.ballast_lane_assessment.model.WorkLog;
import com.jaizcorbe.ballast_lane_assessment.model.WorkLogRequest;
import com.jaizcorbe.ballast_lane_assessment.service.WorkLogService;
import com.jaizcorbe.ballast_lane_assessment.service.exception.BusinessException;
import com.jaizcorbe.ballast_lane_assessment.service.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/work_log")
@AllArgsConstructor
public class WorkLogController {
  private WorkLogService service;

  @GetMapping("/student/{studentId}")
  public Iterable<WorkLog> findAllForStudent(@PathVariable Long studentId) {
    return service.findAllForStudent(studentId);
  }
  @PostMapping
  public WorkLog create(@RequestBody WorkLogRequest workLog) {
    try {
      return service.create(workLog);
    } catch (BusinessException e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @PutMapping
  public WorkLog update(@RequestBody WorkLog workLog) {
    try {
      return service.update(workLog);
    } catch (BusinessException e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @DeleteMapping("/{workLogId}")
  public WorkLog delete(@PathVariable Long workLogId) {
    try {
      return service.delete(workLogId);
    } catch (NotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }
}
