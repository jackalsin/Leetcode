package interviews.oracle._053_Maximum_Subarray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/21/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    assertEquals(6, solution.maxSubArray(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testEmpty(Solution solution) {
    final int[] input = {};
    assertEquals(0, solution.maxSubArray(input));
  }
  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testNull(Solution solution) {
    final int[] input = {};
    assertEquals(0, solution.maxSubArray(input));
  }
  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}