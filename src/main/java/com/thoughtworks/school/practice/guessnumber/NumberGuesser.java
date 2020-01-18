package com.thoughtworks.school.practice.guessnumber;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class NumberGuesser {

  private final String answer;

  public NumberGuesser(NumberGenerator generator) {
    this.answer = generator.generate();
  }

  public String guess(String guessed) {
    if (guessed.chars().distinct().count() < 4) {
      return "Wrong input, input again";
    }
    if (answer.equals(guessed)) {
      return "4A0B";
    }
    Map<String, Long> result = IntStream.range(0, 4)
        .mapToObj(idx -> {
          char answerValue = answer.charAt(idx);
          char guessedValue = guessed.charAt(idx);
          if (answerValue == guessedValue) {
            return "A";
          }
          return answer.indexOf(guessedValue) == -1 ? null : "B";
        })
        .filter(Objects::nonNull)
        .collect(groupingBy(identity(), counting()));

    return result.getOrDefault("A", 0L) + "A" + result.getOrDefault("B", 0L) + "B";
  }
}
