package com.thoughtworks.school.practice.guessnumber;

import java.util.List;
import java.util.stream.IntStream;

public class Answer {

  private List<Character> answer;

  public Answer(List<Character> answer) {
    this.answer = answer;
  }

  public CheckResult check(List<Character> guessNumber) {
    int wrongPosition = 0;

    int correctCount = (int) IntStream.range(0, 4)
        .filter(idx -> answer.get(idx).equals(guessNumber.get(idx)))
        .count();

    if (correctCount == 0 && this.answer.contains(guessNumber.get(3))) {
      wrongPosition = 1;
    }
    return new CheckResult(correctCount, wrongPosition);
  }
}
