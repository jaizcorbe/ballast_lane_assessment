package com.jaizcorbe.ballast_lane_assessment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "First name is mandatory")
  private String firstName;

  @NotBlank(message = "First name is mandatory")
  private String lastName;

  @NotNull(message = "Date of birth is mandatory")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate dateOfBirth;

  @NotBlank(message = "Address is mandatory")
  private String address;

  @NotBlank(message = "Telephone number is mandatory")
  private String telephoneNumber;

  @Transient
  private int age;

  @NotBlank(message = "Email is mandatory")
  @Email(message = "Invalid email format")
  @Column(unique = true)
  private String email;

  private boolean isAdmin;

  public Integer getAge() {
    if(this.dateOfBirth == null) {
      return null;
    }
    return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
  }
}
