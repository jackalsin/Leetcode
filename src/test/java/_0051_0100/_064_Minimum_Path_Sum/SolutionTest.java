package _0051_0100._064_Minimum_Path_Sum;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 4/24/2017.
 */
class SolutionTest {
  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWith1By1(Solution solution) {
    assertEquals(0, solution.minPathSum(new int[][]{{0}}));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWith3By3(Solution solution) {
    assertEquals(9, solution.minPathSum(new int[][]{{1, 2, 3}, {2, 4, 1}, {3, 1, 2}}));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWith3by1(Solution solution) {
    assertEquals(4, solution.minPathSum(new int[][]{{0, 1, 3}}));
  }
}
