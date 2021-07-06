package _1901_1950._1923_Longest_Common_Subpath;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/4/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int n = 5, paths[][] = {{0, 1, 2, 3, 4},
        {2, 3, 4},
        {4, 0, 1, 2, 3}};
    assertEquals(2, solution.longestCommonSubpath(n, paths));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int n = 3, paths[][] = {{0},
        {1},
        {2}};
    assertEquals(0, solution.longestCommonSubpath(n, paths));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int n = 5, paths[][] = {{0, 1, 2, 3, 4},
        {4, 3, 2, 1, 0}};
    assertEquals(1, solution.longestCommonSubpath(n, paths));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int n = 10, paths[][] = {
        {1, 7, 0, 6, 9, 0, 7, 4, 3, 9, 1, 5, 0, 8, 0, 6, 3, 6, 0, 8, 3, 7, 8, 3, 5, 3, 7, 4, 0, 6, 8, 1, 4},
        {1, 7, 0, 6, 9, 0, 7, 4, 3, 9, 1, 5, 0, 8, 0, 6, 3, 6, 0, 8, 3, 7, 8, 3, 5, 3, 7, 4, 0, 6, 8, 1, 5},
        {8, 1, 7, 0, 6, 9, 0, 7, 4, 3, 9, 1, 5, 0, 8, 0, 6, 3, 6, 0, 8, 3, 7, 8, 3, 5, 3, 7, 4, 0, 6, 8, 1}
    };
    assertEquals(32, solution.longestCommonSubpath(n, paths));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}