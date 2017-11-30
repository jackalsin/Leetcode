package _451_500._480_Sliding_Window_Median;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
  private static final double BIAS = 1E-6;
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] input = {1, 3, -1, -3, 5, 3, 6, 7};
    final double[] expected = {1, -1, -1, 3, 5, 6};
    final double[] actual = solution.medianSlidingWindow(input, 3);
    assertArrayEquals(expected, actual, BIAS);
  }

  @Test
  public void testKEqualsLen() throws Exception {
    final int[] input = {2, 3, 4};
    final double[] expected = {3};
    final double[] actual = solution.medianSlidingWindow(input, 3);
    assertArrayEquals(expected, actual, BIAS);
  }

  @Test
  public void testKIsGreaterThanLen() throws Exception {
    final int[] input = {2, 3, 4};
    final double[] expected = {3};
    final double[] actual = solution.medianSlidingWindow(input, 4);
    assertArrayEquals(expected, actual, BIAS);
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
  @Test
  public void testFailedCase1() throws Exception {
    final int[] input = {1, 2, 3, 4, 2, 3, 1, 4, 2};
    final double[] expect = {2.00000, 3.00000, 3.00000, 3.00000, 2.00000, 3.00000, 2.00000};
    final double[] actual = solution.medianSlidingWindow(input, 3);
    assertArrayEquals(expect, actual, BIAS);
  }

  @Test
  public void testFailedCase2() throws Exception {
    final int[] input = {1, 2};
    final double[] expect = {1.00000, 2.00000};
    final double[] actual = solution.medianSlidingWindow(input, 1);
    assertArrayEquals(expect, actual, BIAS);
  }

  @Test
  public void testFailedCase3() throws Exception {
    final int[] input = {5, 2, 2, 7, 3, 7, 9, 0, 2, 3};
    final double[] expect = {3.00000, 3.00000};
    final double[] actual = solution.medianSlidingWindow(input, 9);
    assertArrayEquals(expect, actual, BIAS);
  }


}