package _0201_0250._209_Minimum_Size_Subarray_Sum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/6/2017.
 */
class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(new Solution());
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmpty(Solution solution) {
    assertEquals(0, solution.minSubArrayLen(1, new int[]{}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    final int[] input = new int[]{2, 3, 1, 2, 4, 3};
    assertEquals(2, solution.minSubArrayLen(7, input));
  }

}
