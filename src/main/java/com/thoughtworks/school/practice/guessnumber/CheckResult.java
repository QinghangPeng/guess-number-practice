package com.thoughtworks.school.practice.guessnumber;

public class CheckResult {

  private long correctCount;
  private long wrongPositionCount;

  public CheckResult(long correctCount, long wrongPositionCount) {
    this.correctCount = correctCount;
    this.wrongPositionCount = wrongPositionCount;
  }

  public long getCorrectCount() {
    return correctCount;
  }

  public long getWrongPositionCount() {
    return wrongPositionCount;
  }
}
