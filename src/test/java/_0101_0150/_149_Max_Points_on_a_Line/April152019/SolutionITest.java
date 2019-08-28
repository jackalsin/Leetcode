package _0101_0150._149_Max_Points_on_a_Line.April152019;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/4/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testEmpty(Solution solution) {
    final int[][] input = new int[][]{};
    assertEquals(0, solution.maxPoints(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test1(Solution solution) {
    final int[][] input = {{1, 1}};
    assertEquals(1, solution.maxPoints(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test2(Solution solution) {
    final int[][] input = {{1, 1}, {2, 2}};
    assertEquals(2, solution.maxPoints(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testNormalMax(Solution solution) {
    final int[][] input = {{1, 1}, {2, 2}, {3, 3}, {-1, 1}};
    assertEquals(3, solution.maxPoints(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testAbnormalMax(Solution solution) {
    final int[][] input = {{1, 1}, {1, 2}, {1, 3}, {-1, 1}};
    assertEquals(3, solution.maxPoints(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase(Solution solution) {
    final int[][] points = {{0, 0}, {1, 1}, {1, -1}};
    assertEquals(2, solution.maxPoints(points));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase2OnDup(Solution solution) {
    final int[][] points = {{0, 0}, {1, 1}, {0, 0}};
    assertEquals(3, solution.maxPoints(points));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testDupOnly(Solution solution) {
    final int[][] points = {{0, 0}, {0, 0}};
    assertEquals(2, solution.maxPoints(points));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailed3(Solution solution) {
    final int[][] points = {{2, 3}, {3, 3}, {-5, 3}};
    assertEquals(3, solution.maxPoints(points));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailed4(Solution solution) {
    final int[][] points = {
        {3, 1}, {12, 3}, {3, 1}, {-6, -1}
    };
    assertEquals(4, solution.maxPoints(points));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailed5(Solution solution) {
    final int[][] points = {
        {0, 0}, {94911151, 94911150}, {94911152, 94911151}
    };
    assertEquals(2, solution.maxPoints(points));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailed6(Solution solution) {
    final int[][] points = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
    assertEquals(4, solution.maxPoints(points));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedForConstantSpaceSolution(Solution solution) {
    final int[][] points = {{1, 1}, {2, 1}, {3, 3}, {3, 2}, {5, 5}};
    assertEquals(3, solution.maxPoints(points));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }

}