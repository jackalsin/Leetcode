package _0901_0950._918_Maximum_Sum_Circular_Subarray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/15/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int input[] = {1, -2, 3, -2}, expected = 3, actual = solution.maxSubarraySumCircular(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int input[] = {5, -3, 5}, expected = 10, actual = solution.maxSubarraySumCircular(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int input[] = {3, -1, 2, -1}, expected = 4, actual = solution.maxSubarraySumCircular(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int input[] = {3, -2, 2, -3}, expected = 3, actual = solution.maxSubarraySumCircular(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final int input[] = {-2, -3, -1}, expected = -1, actual = solution.maxSubarraySumCircular(input);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}