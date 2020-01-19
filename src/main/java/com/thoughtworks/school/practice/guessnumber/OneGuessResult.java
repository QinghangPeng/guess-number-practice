package com.thoughtworks.school.practice.guessnumber;

public class OneGuessResult {

  private String input;
  private String output;

  public OneGuessResult(String input, String output) {
    this.input = input;
    this.output = output;
  }

  public String getInput() {
    return input;
  }

  public String getOutput() {
    return output;
  }
}
