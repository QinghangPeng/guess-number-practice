package com.thoughtworks.school.practice.guessnumber;

import java.util.List;
import java.util.stream.IntStream;

public class Answer {

  private static final int ANSWER_SIZE = 4;
  private List<Character> answer;

  public Answer(List<Character> answer) {
    this.answer = answer;
  }

  public CheckResult check(List<Character> guessNumber) {
    if (guessNumber.stream().distinct().count() != ANSWER_SIZE) {
      throw new RuntimeException();
    }

    int correctCount = (int) IntStream.range(0, ANSWER_SIZE)
        .filter(idx -> answer.get(idx).equals(guessNumber.get(idx)))
        .count();

    int wrongPositionCount = (int) IntStream.range(0, ANSWER_SIZE)
        .filter(idx -> answer.contains(guessNumber.get(idx)))
        .filter(idx -> !answer.get(idx).equals(guessNumber.get(idx)))
        .count();
    return new CheckResult(correctCount, wrongPositionCount);
  }
}
