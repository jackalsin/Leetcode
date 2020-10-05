package _0401_0450._416_Partition_Equal_Subset_Sum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] nums = {1, 5, 11, 5};
    assertTrue(solution.canPartition(nums));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] nums = {1, 2, 3, 5};
    assertFalse(solution.canPartition(nums));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase1(Solution solution) {
    final int[] nums = {1, 2, 5};
    assertFalse(solution.canPartition(nums));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase2(Solution solution) {
    final int[] nums = {3, 3, 3, 4, 5};
    assertTrue(solution.canPartition(nums));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SpaceONSquareDpSolution(),
        new SpaceLinearDpSolution()
    );
  }
}