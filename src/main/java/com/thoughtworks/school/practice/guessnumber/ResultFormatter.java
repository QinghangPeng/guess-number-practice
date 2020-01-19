package com.thoughtworks.school.practice.guessnumber;

public class ResultFormatter {

  public String format(CheckResult result) {
    return String.format("%dA%dB", result.getCorrectCount(), result.getWrongPositionCount());
  }
}
