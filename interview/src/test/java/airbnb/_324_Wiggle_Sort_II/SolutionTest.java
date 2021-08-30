package airbnb._324_Wiggle_Sort_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/5/2019.
 */
class SolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase(Solution solution) {
    final int[] input = {1, 2, 2, 1, 2, 1, 1, 1, 1, 2, 2, 2};
    solution.wiggleSort(input);
    assertTrue(isValidWiggle(input), "actual = " + Arrays.toString(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase2(Solution solution) {
    final int[] input = {1};
    solution.wiggleSort(input);
    assertTrue(isValidWiggle(input), "actual = " + Arrays.toString(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase3(Solution solution) {
    final int[] input = {4, 5, 5, 6};
    solution.wiggleSort(input);
    assertTrue(isValidWiggle(input), "actual = " + Arrays.toString(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase4(Solution solution) {
    final int[] input = {5, 3, 1, 2, 6, 7, 8, 5, 5};
    solution.wiggleSort(input);
    assertTrue(isValidWiggle(input), "actual = " + Arrays.toString(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase5(Solution solution) {
    final int[] input = {1, 3, 2, 2, 2, 1, 1, 3, 1, 1, 2};
    solution.wiggleSort(input);
    assertTrue(isValidWiggle(input), "actual = " + Arrays.toString(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase6(Solution solution) {
    final int[] input = {1, 1, 2, 1, 2, 2, 1};
    solution.wiggleSort(input);
    assertTrue(isValidWiggle(input), "actual = " + Arrays.toString(input));
  }

  private boolean isValidWiggle(int[] nums) {
    for (int i = 1; i < nums.length; i += 2) {
      if (nums[i] <= nums[i - 1] || (i + 1 < nums.length && nums[i] <= nums[i + 1])) {
        System.out.println(Arrays.toString(nums));
        return false;
      }
    }
    return true;
  }
}