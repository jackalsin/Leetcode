package interviews.hulu._907_Sum_of_Subarray_Minimums;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/28/2020
 */
class MonoIncreaseStackSolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] input = {3, 1, 2, 4};
    assertEquals(17, solution.sumSubarrayMins(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase85(Solution solution) {
    final int[] input = {85};
    assertEquals(85, solution.sumSubarrayMins(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase(Solution solution) {
    final int[] input = {71, 55, 82, 55};
    assertEquals(593, solution.sumSubarrayMins(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new MonoIncreaseStackSolution()
    );
  }
}