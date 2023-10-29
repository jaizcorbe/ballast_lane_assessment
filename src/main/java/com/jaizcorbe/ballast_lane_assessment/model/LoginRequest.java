package com.jaizcorbe.ballast_lane_assessment.model;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

  @Email(message = "Invalid email format")
  private String email;
}
