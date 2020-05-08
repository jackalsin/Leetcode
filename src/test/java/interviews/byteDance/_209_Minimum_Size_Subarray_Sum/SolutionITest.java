package interviews.byteDance._209_Minimum_Size_Subarray_Sum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jacka
 * @version 1.0 on 5/7/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testEmpty(Solution solution) {
    assertEquals(0, solution.minSubArrayLen(1, new int[]{}));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase(Solution solution) {
    final int[] input = new int[]{2, 3, 1, 2, 4, 3};
    assertEquals(2, solution.minSubArrayLen(7, input));
  }
  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}