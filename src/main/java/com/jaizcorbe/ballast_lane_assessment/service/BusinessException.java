package com.jaizcorbe.ballast_lane_assessment.service;

public class BusinessException extends Exception {

  public BusinessException(String msg) {
    super(msg);
  }
  public BusinessException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
