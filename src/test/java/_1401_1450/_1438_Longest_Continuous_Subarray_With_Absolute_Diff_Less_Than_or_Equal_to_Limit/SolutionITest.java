package _1401_1450._1438_Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/2/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[] nums = {8, 2, 4, 7};
    final int expected = 2, actual = solution.longestSubarray(nums, 4);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[] nums = {9, 10, 1, 7, 9, 3, 9, 9};
    final int expected = 5, actual = solution.longestSubarray(nums, 7);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int[] nums = {34, 24, 70, 27, 40, 26, 32, 47, 11, 36, 12, 97, 58, 12, 84,
        74, 83, 44, 30, 50, 40, 6, 42, 24, 41, 75, 39, 32, 43, 13, 70,
        79, 75, 77, 12, 32, 29, 3, 32, 52, 10, 35, 71,
        10, 94, 10, 3, 82, 2, 38, 97, 46, 64, 61, 20, 13, 65, 100, 42, 10, 66, 86, 23, 23, 100, 20, 19, 41, 40, 14,
        91, 66, 78, 38, 17, 27, 19, 70, 93, 5, 100, 41, 80, 87, 71, 96, 89, 27, 23, 39, 56, 69};
    final int expected = 15, actual = solution.longestSubarray(nums, 72);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new TreeMapSolution(),
        new ONSolution()
    );
  }
}