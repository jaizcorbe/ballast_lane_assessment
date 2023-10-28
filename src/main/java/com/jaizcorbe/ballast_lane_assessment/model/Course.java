package com.jaizcorbe.ballast_lane_assessment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Course name is mandatory")
  @Column(unique = true)
  private String name;

  @NotNull(message = "Course start date is mandatory")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate startDate;

  public boolean isCompleted() {
    if(this.startDate == null) {
      return true;
    }
    int ageInMonths = Period.between(this.startDate, LocalDate.now()).getMonths();
    return  ageInMonths > 6;
  }
}
