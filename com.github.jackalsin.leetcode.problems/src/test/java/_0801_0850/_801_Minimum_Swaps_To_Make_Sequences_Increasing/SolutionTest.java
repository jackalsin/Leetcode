package _0801_0850._801_Minimum_Swaps_To_Make_Sequences_Increasing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] A = {1, 3, 5, 4}, B = {1, 2, 3, 7};
    assertEquals(1, solution.minSwap(A, B));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] A = {1, 3, 5, 4, 5, 6},
        B = {1, 2, 3, 7, 8, 9};
    assertEquals(2, solution.minSwap(A, B));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }
}