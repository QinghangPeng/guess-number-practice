package com.thoughtworks.school.practice.guessnumber;

import static java.util.stream.Collectors.toList;

import java.util.List;

public class GameController {

  private Answer answer;
  private ResultFormatter resultFormatter;

  public GameController(Answer answer, ResultFormatter resultFormatter) {
    this.answer = answer;
    this.resultFormatter = resultFormatter;
  }

  public GuessResult guess(String guessNumber) {
    return new GuessResult(resultFormatter.format(answer.check(toCharList(guessNumber))));
  }

  private List<Character> toCharList(String number) {
    return number.chars().mapToObj(i -> (char) i).collect(toList());
  }
}
