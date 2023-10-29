package com.jaizcorbe.ballast_lane_assessment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkLog {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long studentId;
  @ManyToOne
  private CourseRegistration courseRegistration;
  private TaskCategory taskCategory;
  private String taskDescription;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate taskDate;
  private int taskMinutes;
}
