package _1051_1100._1051_Height_Checker;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/24/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[] heights = {1, 1, 4, 2, 1, 3};
    assertEquals(3, solution.heightChecker(heights));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[] heights = {5, 1, 2, 3, 4};
    assertEquals(5, solution.heightChecker(heights));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int[] heights = {1, 2, 3, 4, 5};
    assertEquals(0, solution.heightChecker(heights));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new CountSolution()
    );
  }
}