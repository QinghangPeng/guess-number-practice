package com.thoughtworks.school.practice.guessnumber;

public class NumberGuesser {

  private final String answer;

  public NumberGuesser(NumberGenerator generator) {
    this.answer = generator.generate();
  }

  public String guess(String theNumber) {
    return "1A0B";
  }
}
