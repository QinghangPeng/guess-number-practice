package com.thoughtworks.school.practice.guessnumber;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

  @Test
  void should_generate_number_with_four_digits_and_each_of_them_are_different() {
    NumberGenerator generator = new NumberGenerator();

    String number = generator.generate();

    assertThat(number.length()).isEqualTo(4);
    assertThat(number.chars().distinct()).hasSize(4);
  }

  @Test
  void should_generate_different_number_when_generate_number_each_time() {
    NumberGenerator generator = new NumberGenerator();

    String first = generator.generate();
    String second = generator.generate();

    assertThat(first).isNotEqualTo(second);
  }
}