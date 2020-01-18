package com.thoughtworks.school.practice.guessnumber;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class NumberGuesser {

  private static final int NUMBER_SIZE = 4;
  private static final String RIGHT_GUESS = "A";
  private static final String RIGHT_NUMBER_WRONG_PLACE = "B";
  private static final long DEFAULT_COUNT = 0L;
  private final String answer;

  public NumberGuesser(NumberGenerator generator) {
    this.answer = generator.generate();
  }

  public String guess(String guessed) {
    if (guessed.chars().distinct().count() != NUMBER_SIZE) {
      return "Wrong input, input again";
    }
    if (answer.equals(guessed)) {
      return "4A0B";
    }
    Map<String, Long> result = IntStream.range(0, NUMBER_SIZE)
        .mapToObj(idx -> {
          char answerValue = answer.charAt(idx);
          char guessedValue = guessed.charAt(idx);
          if (answerValue == guessedValue) {
            return RIGHT_GUESS;
          }
          return answer.indexOf(guessedValue) == -1 ? null : RIGHT_NUMBER_WRONG_PLACE;
        })
        .filter(Objects::nonNull)
        .collect(groupingBy(identity(), counting()));

    return result.getOrDefault(RIGHT_GUESS, DEFAULT_COUNT) + RIGHT_GUESS +
        result.getOrDefault(RIGHT_NUMBER_WRONG_PLACE, DEFAULT_COUNT) + RIGHT_NUMBER_WRONG_PLACE;
  }
}
