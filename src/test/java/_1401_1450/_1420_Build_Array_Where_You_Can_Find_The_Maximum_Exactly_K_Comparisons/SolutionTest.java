package _1401_1450._1420_Build_Array_Where_You_Can_Find_The_Maximum_Exactly_K_Comparisons;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/19/2020
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int n = 2, m = 3, k = 1, expected = 6, actual = solution.numOfArrays(n, m, k);
    assertEquals(expected, actual);
//    Explanation: The possible arrays are [1, 1], [2, 1], [2, 2], [3, 1], [3, 2] [3, 3]
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int n = 5, m = 2, k = 3, expected = 0, actual = solution.numOfArrays(n, m, k);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int n = 9, m = 1, k = 1, expected = 1, actual = solution.numOfArrays(n, m, k);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase5(Solution solution) {
    final int n = 50, m = 100, k = 25, expected = 34549172, actual = solution.numOfArrays(n, m, k);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final int n = 37, m = 17, k = 7, expected = 418930126, actual = solution.numOfArrays(n, m, k);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new BottomUpSolution()
    );
  }
}