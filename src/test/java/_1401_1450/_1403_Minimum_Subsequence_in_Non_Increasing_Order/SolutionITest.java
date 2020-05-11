package _1401_1450._1403_Minimum_Subsequence_in_Non_Increasing_Order;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/4/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] nums = {4, 3, 10, 9, 8};
    final List<Integer> expected = List.of(10, 9), actual = solution.minSubsequence(nums);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] nums = {4,4,7,6,7};
    final List<Integer> expected = List.of(7, 7, 6), actual = solution.minSubsequence(nums);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[] nums = {6};
    final List<Integer> expected = List.of(6), actual = solution.minSubsequence(nums);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}