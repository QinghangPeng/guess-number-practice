package com.thoughtworks.school.practice.guessnumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

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
}