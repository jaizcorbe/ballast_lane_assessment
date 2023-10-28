package com.jaizcorbe.ballast_lane_assessment.config;

import com.jaizcorbe.ballast_lane_assessment.model.Student;
import com.jaizcorbe.ballast_lane_assessment.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class BoostrapConfig {
  @Bean
  public CommandLineRunner bootstrapPlatformContext(
    StudentService studentService) {
    return args -> {
      Student admin = Student.builder()
        .firstName("ballast")
        .lastName("lane")
        .email("admin@ballastlane.com")
        .dateOfBirth(LocalDate.of(1970,1,1))
        .address("Undisclosed place")
        .telephoneNumber("4747-4747")
        .isAdmin(true)
        .build();
      studentService.create(admin);
    };
  }
}

