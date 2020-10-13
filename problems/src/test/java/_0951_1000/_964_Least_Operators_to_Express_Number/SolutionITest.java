package _0951_1000._964_Least_Operators_to_Express_Number;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/12/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int x = 3, target = 19, expected = 5, actual = solution.leastOpsExpressTarget(x, target);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    /* 5 * 5 * 5 * 5 - 5 * 5 * 5 + 5 / 5 */
    final int x = 5, target = 501, expected = 8, actual = solution.leastOpsExpressTarget(x, target);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    /* 100 * 100 * 100 * 100. */
    final int x = 100, target = 100000000, expected = 3, actual = solution.leastOpsExpressTarget(x, target);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}