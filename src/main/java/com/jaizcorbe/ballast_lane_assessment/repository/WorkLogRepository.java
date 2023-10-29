package com.jaizcorbe.ballast_lane_assessment.repository;

import com.jaizcorbe.ballast_lane_assessment.model.WorkLog;
import org.springframework.data.repository.CrudRepository;

public interface WorkLogRepository extends CrudRepository<WorkLog, Long> {
  Iterable<WorkLog> findAllByStudentId(Long studentId);
}
