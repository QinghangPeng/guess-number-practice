package com.thoughtworks.school.practice.guessnumber;

import java.util.Random;
import java.util.stream.Collectors;

public class NumberGenerator {

  public String generate() {
    return new Random().ints()
        .map(i -> i % 10)
        .filter(i -> i >= 0)
        .distinct()
        .limit(4)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining());
  }
}
