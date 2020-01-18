package com.thoughtworks.school.practice.guessnumber;

import java.util.List;

public class GameResult {

  private String current;
  private List<Result> previous;

  public GameResult(String current, List<Result> previous) {
    this.current = current;
    this.previous = previous;
  }

  public String getCurrent() {
    return current;
  }

  public List<Result> getPrevious() {
    return previous;
  }

  public static class Result {

    private String input;
    private String result;

    public Result(String input, String result) {
      this.input = input;
      this.result = result;
    }

    public String getInput() {
      return input;
    }

    public String getResult() {
      return result;
    }
  }
}
