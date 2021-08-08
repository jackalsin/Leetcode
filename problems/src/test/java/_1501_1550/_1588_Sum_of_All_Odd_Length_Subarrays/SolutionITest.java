package _1501_1550._1588_Sum_of_All_Odd_Length_Subarrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/7/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] arr = {1, 4, 2, 5, 3};
    assertEquals(58, solution.sumOddLengthSubarrays(arr));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] arr = {1, 2};
    assertEquals(3, solution.sumOddLengthSubarrays(arr));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[] arr = {10, 11, 12};
    assertEquals(66, solution.sumOddLengthSubarrays(arr));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new ON2Solution(),
        new ONSolution()
    );
  }
}