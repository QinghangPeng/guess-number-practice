package com.thoughtworks.school.practice.guessnumber;

import java.util.List;

public class Answer {

  private List<Character> answer;

  public Answer(List<Character> answer) {
    this.answer = answer;
  }

  public CheckResult check(List<Character> guessNumber) {
    return new CheckResult(0, 0);
  }
}
