package airbnb._280_Wiggle_Sort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/24/2019.
 */
class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] input = {3, 5, 2, 1, 6, 4};
    solution.wiggleSort(input);
    assertIsWiggle(input);
  }

  private static void assertIsWiggle(final int[] nums) {
    for (int i = 1; i < nums.length; i += 2) {
      assertTrue(nums[i] >= nums[i - 1]);
      if (i + 1 < nums.length) {
        assertTrue(nums[i] >= nums[i + 1]);
      }
    }
  }
}