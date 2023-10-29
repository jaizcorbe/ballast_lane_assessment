package com.jaizcorbe.ballast_lane_assessment.config;

import com.jaizcorbe.ballast_lane_assessment.model.Course;
import com.jaizcorbe.ballast_lane_assessment.model.Student;
import com.jaizcorbe.ballast_lane_assessment.service.CourseService;
import com.jaizcorbe.ballast_lane_assessment.service.StudentService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Configuration
public class BoostrapConfig {
  @Bean
  public CommandLineRunner bootstrapPlatformContext(
    StudentService studentService,
    CourseService courseService) {
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
      Student student = Student.builder()
        .firstName("student")
        .lastName("junior")
        .email("student@ballastlane.com")
        .dateOfBirth(LocalDate.of(2000, 1,1))
        .address("Undisclosed place")
        .telephoneNumber("4747-4744")
        .isAdmin(false)
        .build();
      studentService.create(student);
      Course course = Course.builder()
        .name("initial_course")
        .startDate(LocalDate.now().minus(1, ChronoUnit.MONTHS))
        .build();
      courseService.create(course);
    };
  }
}

