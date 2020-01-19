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
    String currentResult = resultFormatter.format(answer.check(toCharList(guessNumber)));
    List<OneGuessResult> previousResultCopy = Collections.unmodifiableList(new ArrayList<>(previousResult));
    previousResult.add(new OneGuessResult(guessNumber, currentResult));
    return new GuessResult(currentResult, previousResultCopy);
  }

  private List<Character> toCharList(String number) {
    return number.chars().mapToObj(i -> (char) i).collect(toList());
  }
}
