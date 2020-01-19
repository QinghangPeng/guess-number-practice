package com.thoughtworks.school.practice.guessnumber;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

  private NumberGenerator generator = new NumberGenerator();

  @Test
  void should_generate_number_with_four_digits_and_they_are_different() {
    String number = generator.generate();

    assertThat(number).hasSize(4);
    assertThat(number.chars().distinct()).hasSize(4);
  }


}