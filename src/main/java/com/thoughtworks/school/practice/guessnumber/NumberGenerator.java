package com.thoughtworks.school.practice.guessnumber;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NumberGenerator {

  public String generate() {
    Random random = new Random();
    Set<String> digits = new HashSet<>();
    while (true) {
      int nextDigit = random.nextInt(10);
      digits.add(String.valueOf(nextDigit));
      if (digits.size() == 4) {
        break;
      }
    }
    return String.join("", digits);
  }
}
