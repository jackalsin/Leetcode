package oracle.kSubsetMinMaxSum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhixi
 * @version 1.0 on 11/30/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int nums[] = {1, 2, 3}, k = 2;
    assertEquals(3, solution.minMaxSum(nums, k));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int nums[] = {2, 2, 3, 3}, k = 2;
    assertEquals(5, solution.minMaxSum(nums, k));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new BruteForceSolution(),
        new DfsMemoSolution()
    );
  }
}