package interviews.linkedin._007_Reverse_Integer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionProvider")
  void reverseZero(Solution solution) {
    assertEquals(0, solution.reverse(0));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void reverseNegativeSingleDigit(Solution solution) {
    assertEquals(-1, solution.reverse(-1));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void reverseNegativeTwoDigits(Solution solution) {
    assertEquals(-12, solution.reverse(-21));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void reversePositiveSingleDigit(Solution solution) {
    assertEquals(1, solution.reverse(1));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void reversePositiveTwoDigits(Solution solution) {
    assertEquals(12, solution.reverse(21));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void reverseMinValue(Solution solution) {
    assertEquals(0, solution.reverse(Integer.MIN_VALUE));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void reverseOverflow(Solution solution) {
    assertEquals(-2143847412, solution.reverse(-2147483412));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}