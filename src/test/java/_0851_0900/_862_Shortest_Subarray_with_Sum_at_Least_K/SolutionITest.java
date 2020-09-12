package _0851_0900._862_Shortest_Subarray_with_Sum_at_Least_K;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/12/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int A[] = {1}, K = 1, actual = solution.shortestSubarray(A, K);
    assertEquals(1, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int A[] = {1, 2}, K = 4, actual = solution.shortestSubarray(A, K);
    assertEquals(-1, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int A[] = {2, -1, 2}, K = 3, actual = solution.shortestSubarray(A, K);
    assertEquals(3, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int A[] = {84, -37, 32, 40, 95}, K = 167, actual = solution.shortestSubarray(A, K);
    assertEquals(3, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}