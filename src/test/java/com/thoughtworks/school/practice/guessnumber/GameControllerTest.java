package com.thoughtworks.school.practice.guessnumber;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GameControllerTest {

  @Mock
  private Answer answer;
  @Mock
  private ResultFormatter formatter;
  @InjectMocks
  private GameController gameController;

  @Test
  void should_return_formatted_result() {
    CheckResult checkResult = new CheckResult(0, 0);
    given(answer.check(any())).willReturn(checkResult);
    given(formatter.format(checkResult)).willReturn("0A0B");

    GuessResult result = gameController.guess("5678");

    assertThat(result.getCurrent()).isEqualTo("0A0B");
  }

  @Test
  void should_return_previous_input_and_output() {
    CheckResult checkResult = new CheckResult(0, 0);
    given(answer.check(any())).willReturn(checkResult);
    given(formatter.format(checkResult)).willReturn("0A0B");
    gameController.guess("5678");

    GuessResult result = gameController.guess("5678");

    assertThat(result.getPrevious().stream().map(OneGuessResult::getInput)).contains("5678");
    assertThat(result.getPrevious().stream().map(OneGuessResult::getOutput)).contains("0A0B");
  }

  @Test
  void should_return_congratulations_when_win_the_game() {
    CheckResult checkResult = new CheckResult(4, 0);
    given(answer.check(any())).willReturn(checkResult);
    given(formatter.format(checkResult)).willReturn("4A0B");

    GuessResult result = gameController.guess("1234");

    assertThat(result.getMessage()).isEqualTo("Congratulations, you win !");
  }

  @Test
  void should_return_error_message_when_input_is_invalid() {
    given(answer.check(any())).willThrow(new RuntimeException());

    GuessResult result = gameController.guess("12");

    assertThat(result.getCurrent()).isEqualTo("Wrong input, input again");
  }

  @Test
  void should_throw_exception_when_already_win_the_game() {
    CheckResult checkResult = new CheckResult(4, 0);
    given(answer.check(any())).willReturn(checkResult);
    given(formatter.format(checkResult)).willReturn("4A0B");
    gameController.guess("1234");

    assertThatExceptionOfType(RuntimeException.class)
        .isThrownBy(() -> gameController.guess("1234"));
  }

  @Test
  void should_win_the_game_when_guess_right_at_6th_time() {
    CheckResult notRightResult = new CheckResult(1, 0);
    CheckResult rightResult = new CheckResult(4, 0);
    doReturn(notRightResult).when(answer).check(eq(asList('1', '5', '6', '7')));
    doReturn(rightResult).when(answer).check(eq(asList('1', '2', '3', '4')));
    doReturn("1A0B").when(formatter).format(notRightResult);
    doReturn("4A0B").when(formatter).format(rightResult);
    IntStream.range(0, 5).forEach(i -> gameController.guess("1235"));

    GuessResult result = gameController.guess("1234");

    assertThat(result.getMessage()).isEqualTo("Congratulations, you win !");
  }

  @Test
  void should_throw_exception_when_guess_number_more_than_6_times() {
    CheckResult checkResult = new CheckResult(0, 0);
    given(answer.check(any())).willReturn(checkResult);
    given(formatter.format(checkResult)).willReturn("0A0B");
    IntStream.range(0, 6).forEach(i -> gameController.guess("5678"));

    assertThatExceptionOfType(RuntimeException.class)
        .isThrownBy(() -> gameController.guess("5678"));
  }
}