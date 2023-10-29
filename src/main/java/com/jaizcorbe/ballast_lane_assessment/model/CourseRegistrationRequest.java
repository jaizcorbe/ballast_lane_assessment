package com.jaizcorbe.ballast_lane_assessment.model;

import jakarta.validation.constraints.NotNull;

public record CourseRegistrationRequest(@NotNull Long studentId, @NotNull Long courseId) {
}
