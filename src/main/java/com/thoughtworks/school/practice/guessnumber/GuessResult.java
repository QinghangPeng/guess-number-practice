package com.thoughtworks.school.practice.guessnumber;

import java.util.List;

public class GuessResult {

  private String current;
  private List<OneGuessResult> previous;

  public GuessResult(String current, List<OneGuessResult> previous) {
    this.current = current;
    this.previous = previous;
  }

  public String getCurrent() {
    return current;
  }

  public List<OneGuessResult> getPrevious() {
    return previous;
  }

}
