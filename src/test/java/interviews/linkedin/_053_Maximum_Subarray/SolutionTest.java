package interviews.linkedin._053_Maximum_Subarray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionProvider")
  void maxSubArrayWithPositiveMore(Solution solution) {
    final int[] input = new int[]{4, 5, 3, -3, 2};
    assertEquals(12, solution.maxSubArray(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithOneElement(Solution solution) {
    final int[] input = new int[]{3};
    assertEquals(3, solution.maxSubArray(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithOneNegativeElement(Solution solution) {
    final int[] input = new int[]{-3};
    assertEquals(-3, solution.maxSubArray(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithTwoNegativeElement(Solution solution) {
    final int[] input = new int[]{-3, -2};
    assertEquals(-2, solution.maxSubArray(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithTwoNegativeElementReverse(Solution solution) {
    final int[] input = new int[]{-2, -3};
    assertEquals(-2, solution.maxSubArray(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV()
    );
  }
}