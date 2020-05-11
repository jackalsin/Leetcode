package _0051_0100._053_Maximum_Subarray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 3/27/2017.
 */
public class SolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(new Solution());
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void maxSubArrayWithPositiveMore(Solution solution) {
    final int[] input = new int[]{4, 5, 3, -3, 2};
    assertEquals(12, solution.maxSubArray(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithOneElement(Solution solution) {
    final int[] input = new int[]{3};
    assertEquals(3, solution.maxSubArray(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithOneNegativeElement(Solution solution) {
    final int[] input = new int[]{-3};
    assertEquals(-3, solution.maxSubArray(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithTwoNegativeElement(Solution solution) {
    final int[] input = new int[]{-3, -2};
    assertEquals(-2, solution.maxSubArray(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithTwoNegativeElementReverse(Solution solution) {
    final int[] input = new int[]{-2, -3};
    assertEquals(-2, solution.maxSubArray(input));
  }
}