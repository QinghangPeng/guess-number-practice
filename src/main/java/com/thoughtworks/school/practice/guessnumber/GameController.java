package com.thoughtworks.school.practice.guessnumber;

public class GameController {

  private final NumberGuesser numberGuesser;

  public GameController(NumberGuesser numberGuesser) {
    this.numberGuesser = numberGuesser;
  }

  public String guess(String guessedNumber) {
    return numberGuesser.guess(guessedNumber);
  }
}
