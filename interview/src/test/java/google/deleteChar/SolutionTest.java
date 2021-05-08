package google.deleteChar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/7/2021
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCaseSame(Solution solution) {
    assertEquals(0, solution.delete("abc", "abc"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCaseAMore1B(Solution solution) {
    assertEquals(1, solution.delete("abcd", "acd"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCaseAMore2B(Solution solution) {
    assertEquals(2, solution.delete("abcd", "ac"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCaseALess1B(Solution solution) {
    assertEquals(1, solution.delete("abc", "abcd"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCaseALess2B(Solution solution) {
    assertEquals(2, solution.delete("ac", "abcd"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCaseNotTransform(Solution solution) {
    assertEquals(-1, solution.delete("adc", "abcd"));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}