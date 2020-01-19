package com.thoughtworks.school.practice.guessnumber;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameController {

  private Answer answer;
  private ResultFormatter resultFormatter;
  private List<OneGuessResult> previousResult = new ArrayList<>();

  public GameController(Answer answer, ResultFormatter resultFormatter) {
    this.answer = answer;
    this.resultFormatter = resultFormatter;
  }

  public GuessResult guess(String guessNumber) {
    String currentResult = checkAndFormat(guessNumber);
    List<OneGuessResult> previousResultCopy = Collections.unmodifiableList(new ArrayList<>(previousResult));
    previousResult.add(new OneGuessResult(guessNumber, currentResult));
    String message = currentResult.equals("4A0B") ? "Congratulations, you win !" : null;
    return new GuessResult(currentResult, previousResultCopy, message);
  }

  private String checkAndFormat(String guessNumber) {
    try {
      return resultFormatter.format(answer.check(toCharList(guessNumber)));
    } catch (RuntimeException e) {
      return "Wrong input, input again";
    }
  }

  private List<Character> toCharList(String number) {
    return number.chars().mapToObj(i -> (char) i).collect(toList());
  }
}
