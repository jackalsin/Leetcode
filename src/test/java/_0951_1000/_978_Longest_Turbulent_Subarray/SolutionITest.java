package _0951_1000._978_Longest_Turbulent_Subarray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhixi
 * @version 1.0 on 10/4/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int A[] = {9, 4, 2, 10, 7, 8, 8, 1, 9}, expected = 5, actual = solution.maxTurbulenceSize(A);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int A[] = {4, 8, 12, 16}, expected = 2, actual = solution.maxTurbulenceSize(A);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int A[] = {100}, expected = 1, actual = solution.maxTurbulenceSize(A);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    //               0, 1, 2, 3, 4, 5, 6, 7, 8, 9
    final int A[] = {0, 1, 1, 0, 1, 0, 1, 1, 0, 0}, expected = 5, actual = solution.maxTurbulenceSize(A);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}