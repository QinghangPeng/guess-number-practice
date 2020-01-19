package com.thoughtworks.school.practice.guessnumber;

import java.util.List;

public class Answer {

  private List<Character> answer;

  public Answer(List<Character> answer) {
    this.answer = answer;
  }

  public CheckResult check(List<Character> guessNumber) {
    int correctCount = 0;
    if (this.answer.get(0).equals(guessNumber.get(0))) {
      correctCount = 1;
    }
    return new CheckResult(correctCount, 0);
  }
}