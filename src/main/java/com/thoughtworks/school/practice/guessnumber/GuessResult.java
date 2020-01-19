package com.thoughtworks.school.practice.guessnumber;

import java.util.Objects;

public class GuessResult {

  private String current;

  public GuessResult(String current) {
    this.current = current;
  }

  public String getCurrent() {
    return current;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GuessResult that = (GuessResult) o;
    return Objects.equals(current, that.current);
  }

  @Override
  public int hashCode() {
    return Objects.hash(current);
  }
}
