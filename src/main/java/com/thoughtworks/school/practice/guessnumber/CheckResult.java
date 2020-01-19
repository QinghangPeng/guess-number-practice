package com.thoughtworks.school.practice.guessnumber;

public class CheckResult {

  private int correctCount;
  private int wrongPositionCount;

  public CheckResult(int correctCount, int wrongPositionCount) {
    this.correctCount = correctCount;
    this.wrongPositionCount = wrongPositionCount;
  }

  public int getCorrectCount() {
    return correctCount;
  }

  public int getWrongPositionCount() {
    return wrongPositionCount;
  }
}
