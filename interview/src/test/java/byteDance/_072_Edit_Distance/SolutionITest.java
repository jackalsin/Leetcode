package byteDance._072_Edit_Distance;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhixi
 * @version 1.0 on 5/7/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithEmptyCouples(Solution solution) {
    assertEquals(0, solution.minDistance("", ""));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithEmpty(Solution solution) {
    assertEquals(5, solution.minDistance("", "word1"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithCommonCase1(Solution solution) {
    assertEquals(2, solution.minDistance("word", "wcd"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithCommonCase2(Solution solution) {
    assertEquals(3, solution.minDistance("horse", "ros"));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}