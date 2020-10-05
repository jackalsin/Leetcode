package linkedin._152_Maximum_Product_Subarray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/21/2017.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedNegative(Solution solution) {
    final int[] nums = {-2};
    assertEquals(-2, solution.maxProduct(nums));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    final int[] nums = {2, 3, -2, 4};
    assertEquals(6, solution.maxProduct(nums));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testZero(Solution solution) {
    final int[] nums = {0, 2};
    assertEquals(2, solution.maxProduct(nums));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV(),
        new SolutionV(),
        new SolutionVI()
    );
  }
}
