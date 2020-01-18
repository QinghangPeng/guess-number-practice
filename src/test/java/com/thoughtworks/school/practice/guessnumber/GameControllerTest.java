package com.thoughtworks.school.practice.guessnumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GameControllerTest {

  @Mock
  private NumberGuesser numberGuesser;
  @InjectMocks
  private GameController gameController;

  @Test
  void should_return_current_result_when_guess() {
    String guessedNumber = "1234";
    given(numberGuesser.guess(guessedNumber)).willReturn("4A0B");

    String result = gameController.guess(guessedNumber);

    assertThat(result).isEqualTo("4A0B");
  }
}