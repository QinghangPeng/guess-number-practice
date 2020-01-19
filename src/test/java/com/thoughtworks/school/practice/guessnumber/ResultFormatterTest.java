package com.thoughtworks.school.practice.guessnumber;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ResultFormatterTest {

  @Test
  void should_format_0_correct_0_wrong_position_as_0A0B() {
    ResultFormatter formatter = new ResultFormatter();
    CheckResult result = new CheckResult(0, 0);

    String formattedResult = formatter.format(result);

    assertThat(formattedResult).isEqualTo("0A0B");
  }
}