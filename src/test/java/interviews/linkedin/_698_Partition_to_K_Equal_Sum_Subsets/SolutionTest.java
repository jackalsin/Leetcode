package interviews.linkedin._698_Partition_to_K_Equal_Sum_Subsets;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/16/2017.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase(Solution solution) {
    final int[] input = {4, 3, 2, 3, 5, 2, 1};
    assertTrue(solution.canPartitionKSubsets(input, 4));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase1(Solution solution) {
    final int[] input = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    System.out.println(input.length);
    assertTrue(solution.canPartitionKSubsets(input, 1));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase2(Solution solution) {
    // (15,1), (4, 1, 1, 10), (3, 11, 1, 1)
    final int[] input = {4, 15, 1, 1, 1, 1, 3, 11, 1, 10};
    assertTrue(solution.canPartitionKSubsets(input, 3));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase3(Solution solution) {
    final int[] input = {1, 1, 2, 4};
    assertFalse(solution.canPartitionKSubsets(input, 4));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase4(Solution solution) {
    final int[] input = {5, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 3};
    assertTrue(solution.canPartitionKSubsets(input, 15));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedOnTLE(Solution solution) {
    final int[] input = {605, 454, 322, 218, 8, 19, 651, 2220, 175, 710, 2666, 350, 252, 2264,
        327, 1843};
    final long startTime = System.nanoTime();
    solution.canPartitionKSubsets(input, 4);
    final long endTime = System.nanoTime();
    System.out.println((endTime - startTime) / 1e6);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV(),
        new SolutionV()
    );
  }
}
