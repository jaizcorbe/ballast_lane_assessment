package com.jaizcorbe.ballast_lane_assessment.service.exception;

public class NotFoundException extends BusinessException {

  public NotFoundException(String msg) {
    super(msg);
  }
  public NotFoundException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
