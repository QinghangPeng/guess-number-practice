package com.thoughtworks.school.practice.guessnumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NumberGuesserTest {

  @Mock
  private NumberGenerator numberGenerator;
  private NumberGuesser numberGuesser;

  @BeforeEach
  void setUp() {
    given(numberGenerator.generate()).willReturn("1234");
    numberGuesser = new NumberGuesser(numberGenerator);
  }

  @Test
  void should_return_1A0B_when_the_answer_is_1234_and_given_1567() {
    String result = numberGuesser.guess("1567");

    assertThat(result).isEqualTo("1A0B");
  }

  @Test
  void should_return_0A1B_when_the_answer_is_1234_and_given_5671() {
    String result = numberGuesser.guess("5671");

    assertThat(result).isEqualTo("0A1B");
  }

  @Test
  void should_return_4A0B_when_the_answer_is_1234_and_given_1234() {
    String result = numberGuesser.guess("1234");

    assertThat(result).isEqualTo("4A0B");
  }

  @Test
  void should_return_error_message_when_given_number_has_duplicate_digit() {
    String result = numberGuesser.guess("1233");

    assertThat(result).isEqualTo("Wrong input, input again");
  }
}