package com.thoughtworks.school.practice.guessnumber;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NumberGenerator {

  private static final int BOUND = 10;
  private static final int NUMBER_SIZE = 4;

  public String generate() {
    Random random = new Random();
    Set<String> digits = new HashSet<>();
    while (true) {
      int nextDigit = random.nextInt(BOUND);
      digits.add(String.valueOf(nextDigit));
      if (digits.size() == NUMBER_SIZE) {
        break;
      }
    }
    return String.join("", digits);
  }
}
