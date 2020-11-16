package _1051_1100._1064_Fixed_Point;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhixi
 * @version 1.0 on 11/15/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[] input = {-10, -5, 0, 3, 7};
    assertEquals(3, solution.fixedPoint(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[] input = {0, 2, 5, 8, 17};
    assertEquals(0, solution.fixedPoint(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int[] input = {-10, -5, 3, 4, 7, 9};
    assertEquals(-1, solution.fixedPoint(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}