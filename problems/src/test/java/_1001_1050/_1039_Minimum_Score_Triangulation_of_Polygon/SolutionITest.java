package _1001_1050._1039_Minimum_Score_Triangulation_of_Polygon;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhixi
 * @version 1.0 on 10/23/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[] input = {1, 2, 3};
    assertEquals(6, solution.minScoreTriangulation(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[] input = {3, 7, 4, 5};
    assertEquals(144, solution.minScoreTriangulation(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int[] input = {1, 3, 1, 4, 1, 5};
    assertEquals(13, solution.minScoreTriangulation(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final int[] input = {4, 3, 4, 3, 5};
    assertEquals(132, solution.minScoreTriangulation(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase5(Solution solution) {
    final int[] input = {5, 5, 1, 4, 2};
    assertEquals(43, solution.minScoreTriangulation(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase6(Solution solution) {
    final int[] input = {2, 2, 2, 2, 1};
    assertEquals(12, solution.minScoreTriangulation(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}