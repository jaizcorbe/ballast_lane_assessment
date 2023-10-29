package com.jaizcorbe.ballast_lane_assessment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkLogRequest {
  private Long studentId;
  private Long registrationId;
  private TaskCategory taskCategory;
  private String taskDescription;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate taskDate;
  int taskMinutes;
}
