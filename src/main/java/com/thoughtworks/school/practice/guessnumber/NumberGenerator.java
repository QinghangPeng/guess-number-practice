package com.thoughtworks.school.practice.guessnumber;

import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;

public class NumberGenerator {

  private static final int NUMBER_SIZE = 4;

  public String generate() {
    return new Random().ints()
        .map(mod10())
        .filter(notNegative())
        .distinct()
        .limit(NUMBER_SIZE)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining());
  }

  private IntPredicate notNegative() {
    return i -> i >= 0;
  }

  private IntUnaryOperator mod10() {
    return i -> i % 10;
  }
}
