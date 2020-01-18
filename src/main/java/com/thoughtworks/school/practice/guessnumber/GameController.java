package com.thoughtworks.school.practice.guessnumber;

import com.thoughtworks.school.practice.guessnumber.GameResult.Result;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameController {

  private final NumberGuesser numberGuesser;
  private List<Result> previousResult = new ArrayList<>();

  public GameController(NumberGuesser numberGuesser) {
    this.numberGuesser = numberGuesser;
  }

  public GameResult guess(String guessedNumber) {
    List<Result> previous = Collections.unmodifiableList(new ArrayList<>(previousResult));
    if (previousResult.size() >= 6) {
      return new GameResult(null, previous);
    }
    String currentResult = numberGuesser.guess(guessedNumber);
    previousResult.add(new Result(guessedNumber, currentResult));
    return new GameResult(currentResult, previous);
  }
}
