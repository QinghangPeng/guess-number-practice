package com.thoughtworks.school.practice.guessnumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.thoughtworks.school.practice.guessnumber.GameResult.Result;
import java.util.stream.IntStream;
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

    GameResult result = gameController.guess(guessedNumber);

    assertThat(result.getCurrent()).isEqualTo("4A0B");
  }

  @Test
  void should_return_previous_input_and_result_when_guess() {
    String guessedNumber = "1236";
    given(numberGuesser.guess(guessedNumber)).willReturn("3A0B");
    gameController.guess(guessedNumber);

    GameResult result = gameController.guess(guessedNumber);

    assertThat(result.getPrevious().stream().map(Result::getInput)).contains(guessedNumber);
    assertThat(result.getPrevious().stream().map(Result::getResult)).contains("3A0B");
  }

  @Test
  void should_not_guess_when_already_guess_failed_6_times() {
    String guessedNumber = "1236";
    given(numberGuesser.guess(guessedNumber)).willReturn("3A0B");
    IntStream.range(0,6).forEach(i -> gameController.guess(guessedNumber));

    gameController.guess(guessedNumber);

    verify(numberGuesser, times(6)).guess(guessedNumber);
  }
}