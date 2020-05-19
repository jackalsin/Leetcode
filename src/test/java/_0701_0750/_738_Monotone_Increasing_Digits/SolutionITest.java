package _0701_0750._738_Monotone_Increasing_Digits;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/18/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    assertEquals(9, solution.monotoneIncreasingDigits(10));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    assertEquals(1234, solution.monotoneIncreasingDigits(1234));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase332(Solution solution) {
    assertEquals(299, solution.monotoneIncreasingDigits(332));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}