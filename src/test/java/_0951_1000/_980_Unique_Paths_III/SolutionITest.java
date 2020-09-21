package _0951_1000._980_Unique_Paths_III;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/20/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] input = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
    assertEquals(2, solution.uniquePathsIII(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[][] input = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}};
    assertEquals(4, solution.uniquePathsIII(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[][] input = {
        {0, 1},
        {2, 0}};
    assertEquals(0, solution.uniquePathsIII(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}