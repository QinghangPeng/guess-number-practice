package com.thoughtworks.school.practice.guessnumber;

import java.util.List;

public class GuessResult {

  private String current;
  private List<OneGuessResult> previous;
  private String message;

  public GuessResult(String current, List<OneGuessResult> previous, String message) {
    this.current = current;
    this.previous = previous;
    this.message = message;
  }

  public String getCurrent() {
    return current;
  }

  public List<OneGuessResult> getPrevious() {
    return previous;
  }

  public String getMessage() {
    return message;
  }
}
