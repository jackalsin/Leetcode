package _0401_0450._403_Frog_Jump;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new DfsSolution(),
        new SlowSolution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] nums = {0};
    assertTrue(solution.canCross(nums));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] nums = {0, 1, 3, 5, 6, 8, 12, 17};
    assertTrue(solution.canCross(nums));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[] nums = {0, 1, 2, 3, 4, 8, 9, 11};
    assertFalse(solution.canCross(nums));
  }

}