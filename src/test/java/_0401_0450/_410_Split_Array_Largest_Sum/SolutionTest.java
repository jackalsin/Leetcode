package _0401_0450._410_Split_Array_Largest_Sum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/8/2019.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] nums = {1, 2, 3, 6};
    assertEquals(6, solution.splitArray(nums, 2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] nums = {7, 2, 5, 10, 8};
    assertEquals(18, solution.splitArray(nums, 2));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new BinarySearchSolution(),
        new DpSolutionII(),
        new DpSolutionI()
    );
  }
}