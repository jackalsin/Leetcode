package _0951_1000._974_Subarray_Sums_Divisible_by_K;

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
    //                   0, 1, 2,  3,  4, 5
    //                   0, 1, 3,  3,  6  7
    final int input[] = {4, 5, 0, -2, -3, 1}, K = 5,
        expected = 7, actual = solution.subarraysDivByK(input, K);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    //                   0,  1,  2
    //                   0,  1,  3
    final int input[] = {1, -10, 5}, K = 9,
        expected = 1, actual = solution.subarraysDivByK(input, K);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    //                   0,  1,  2
    //                   0,  1,  3
    final int input[] = {2}, K = 6,
        expected = 0, actual = solution.subarraysDivByK(input, K);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}