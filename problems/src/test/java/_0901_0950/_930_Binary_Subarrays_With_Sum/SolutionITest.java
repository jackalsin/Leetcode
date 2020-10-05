package _0901_0950._930_Binary_Subarrays_With_Sum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/22/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int A[] = {1, 0, 1, 0, 1}, S = 2;
    assertEquals(4, solution.numSubarraysWithSum(A, S));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int A[] = {1, 0, 0, 1, 0, 1}, S = 0;
    assertEquals(4, solution.numSubarraysWithSum(A, S));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SpaceONSolution(),
        new SpaceO1Solution()
    );
  }
}