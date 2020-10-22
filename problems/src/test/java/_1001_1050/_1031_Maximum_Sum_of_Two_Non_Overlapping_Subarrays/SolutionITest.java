package _1001_1050._1031_Maximum_Sum_of_Two_Non_Overlapping_Subarrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/21/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int A[] = {0, 6, 5, 2, 2, 5, 1, 9, 4}, L = 1, M = 2,
        expected = 20, actual = solution.maxSumTwoNoOverlap(A, L, M);
    assertEquals(expected, actual);
//    Explanation: One choice of subarrays is [9] with length 1, and [6,5] with length 2.
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int A[] = {3, 8, 1, 3, 2, 1, 8, 9, 0}, L = 3, M = 2,
        expected = 29, actual = solution.maxSumTwoNoOverlap(A, L, M);
    assertEquals(expected, actual);
//    One choice of subarrays is[3, 8, 1]with length 3, and[8, 9]with length 2.
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int A[] = {2, 1, 5, 6, 0, 9, 5, 0, 3, 8}, L = 4, M = 3,
        expected = 31, actual = solution.maxSumTwoNoOverlap(A, L, M);
    assertEquals(expected, actual);
//    One choice of subarrays is[5, 6, 0, 9]with length 4, and[3, 8]with length 3.
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final int A[] = {1, 0, 3}, L = 1, M = 2,
        expected = 4, actual = solution.maxSumTwoNoOverlap(A, L, M);
    assertEquals(expected, actual);
//    One choice of subarrays is[5, 6, 0, 9]with length 4, and[3, 8]with length 3.
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}