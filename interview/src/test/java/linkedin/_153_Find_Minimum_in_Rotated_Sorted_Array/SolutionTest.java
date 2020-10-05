package linkedin._153_Find_Minimum_in_Rotated_Sorted_Array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/4/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOneElement(Solution solution) {
    final int[] input = new int[]{1};
    assertEquals(1, solution.findMin(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testTwoElement(Solution solution) {
    final int[] input = new int[]{1, 2};
    assertEquals(1, solution.findMin(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testTwoElements(Solution solution) {
    final int[] input = new int[]{2, 1};
    assertEquals(1, solution.findMin(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test5Elements(Solution solution) {
    final int[] input = new int[]{2, 3, 4, 0, 1};
    assertEquals(0, solution.findMin(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}