package _1001_1050._1027_Longest_Arithmetic_Subsequence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/20/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int A[] = {3, 6, 9, 12}, expected = 4, actual = solution.longestArithSeqLength(A);
    //    The whole array is an arithmetic sequence with steps of length = 3.
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int A[] = {9, 4, 7, 2, 10}, expected = 3, actual = solution.longestArithSeqLength(A);
    //    The longest arithmetic subsequence is [4,7,10].
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int A[] = {20, 1, 15, 3, 10, 5, 8}, expected = 4, actual = solution.longestArithSeqLength(A);
    //    The longest arithmetic subsequence is[20, 15, 10, 5].
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int A[] = {12, 28, 13, 6, 34, 36, 53, 24, 29, 2, 23, 0, 22, 25, 53, 34, 23, 50, 35, 43, 53, 11, 48, 56, 44,
        53, 31, 6, 31, 57, 46, 6, 17, 42, 48, 28, 5, 24, 0, 14, 43, 12, 21, 6, 30, 37, 16, 56, 19, 45, 51, 10, 22, 38
        , 39, 23, 8, 29, 60, 18}, expected = 4, actual = solution.longestArithSeqLength(A);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}