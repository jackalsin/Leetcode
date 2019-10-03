package interviews.linkedin._081_Search_in_Rotated_Sorted_Array_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 8/4/2019
 */
class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[] nums = {2, 5, 6, 0, 0, 1, 2};
    final int target = 0;
    assertTrue(solution.search(nums, target));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[] nums = {2, 5, 6, 0, 0, 1, 2};
    final int target = 3;
    assertFalse(solution.search(nums, target));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase1(Solution solution) {
    final int[] nums = {3, 1};
    final int target = 1;
    assertTrue(solution.search(nums, target));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase2(Solution solution) {
    final int[] nums = {1};
    final int target = 0;
    assertFalse(solution.search(nums, target));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase3(Solution solution) {
    final int[] nums = {1, 2, 1};
    final int target = 1;
    assertTrue(solution.search(nums, target));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase4(Solution solution) {
    final int[] nums = {1, 2, 1};
    final int target = 1;
    assertTrue(solution.search(nums, target));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase5(Solution solution) {
    final int[] nums = {3, 5, 1};
    final int target = 3;
    assertTrue(solution.search(nums, target));
  }

  static Stream<Solution> solutionProvider() {
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