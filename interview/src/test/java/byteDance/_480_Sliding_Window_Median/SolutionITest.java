package byteDance._480_Sliding_Window_Median;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 3/22/2021
 */
class SolutionITest {
  private static final double BIAS = 1E-6;

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase1(Solution solution) {
    final int[] input = {1, 3, -1, -3, 5, 3, 6, 7};
    final double[] expected = {1, -1, -1, 3, 5, 6};
    final double[] actual = solution.medianSlidingWindow(input, 3);
    assertArrayEquals(expected, actual, BIAS, "actual = " + Arrays.toString(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testKEqualsLen(Solution solution) {
    final int[] input = {2, 3, 4};
    final double[] expected = {3};
    final double[] actual = solution.medianSlidingWindow(input, 3);
    assertArrayEquals(expected, actual, BIAS, "actual = " + Arrays.toString(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testKIsGreaterThanLen(Solution solution) {
    final int[] input = {2, 3, 4};
    final double[] expected = {3};
    final double[] actual = solution.medianSlidingWindow(input, 4);
    assertArrayEquals(expected, actual, BIAS, "actual = " + Arrays.toString(actual));
  }

  /**
   * The invariant is not hold
   * Add the following code:
   * <p>
   * if (small.peek() > big.peek()) {
   * int smallPeek = small.remove(), bigPeek = big.remove();
   * big.add(smallPeek);
   * small.add(bigPeek);
   * }
   *
   * @throws Exception
   */
  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailedCase1(Solution solution) {
    final int[] input = {1, 2, 3, 4, 2, 3, 1, 4, 2};
    final double[] expect = {2.00000, 3.00000, 3.00000, 3.00000, 2.00000, 3.00000, 2.00000};
    final double[] actual = solution.medianSlidingWindow(input, 3);
    assertArrayEquals(expect, actual, BIAS, "actual = " + Arrays.toString(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailedCase2(Solution solution) {
    final int[] input = {1, 2};
    final double[] expect = {1.00000, 2.00000};
    final double[] actual = solution.medianSlidingWindow(input, 1);
    assertArrayEquals(expect, actual, BIAS, "actual = " + Arrays.toString(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailedCase3(Solution solution) {
    final int[] input = {5, 2, 2, 7, 3, 7, 9, 0, 2, 3};
    final double[] expect = {3.00000, 3.00000};
    final double[] actual = solution.medianSlidingWindow(input, 9);
    assertArrayEquals(expect, actual, BIAS, "actual = " + Arrays.toString(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}