package com.thoughtworks.school.practice.guessnumber;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;

import java.util.List;
import java.util.Map;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
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

    Map<Boolean, Long> correctAndWrongPositionCounts = IntStream.range(0, ANSWER_SIZE)
        .filter(digitIsInTheAnswer(guessNumber))
        .boxed()
        .collect(partitioningBy(digitIsCorrect(guessNumber), counting()));

    return new CheckResult(correctAndWrongPositionCounts.get(Boolean.TRUE), correctAndWrongPositionCounts.get(Boolean.FALSE));
  }

  private Predicate<Integer> digitIsCorrect(List<Character> guessNumber) {
    return idx -> answer.get(idx).equals(guessNumber.get(idx));
  }

  private IntPredicate digitIsInTheAnswer(List<Character> guessNumber) {
    return idx -> answer.contains(guessNumber.get(idx));
  }
}
