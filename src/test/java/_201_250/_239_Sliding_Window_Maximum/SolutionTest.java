package _201_250._239_Sliding_Window_Maximum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 8/19/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnline() throws Exception {
    final int[] input = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
    final int[] expected = new int[] {3, 3, 5, 5, 6, 7};
    assertArrayEquals(expected, solution.maxSlidingWindow(input, 3));
  }

  @Test
  public void testEmpty() throws Exception {
    final int[] input = new int[] {};
    final int[] expected = new int[] {};
    assertArrayEquals(expected, solution.maxSlidingWindow(input, 0));
  }

  @Test
  public void testFailedCase() throws Exception {
    final int[] input = new int[] {-7,-8,7,5,7,1,6,0};
    final int[] expected = new int[] {7, 7, 7, 7, 7};
    assertArrayEquals(expected, solution.maxSlidingWindow(input, 4));
  }

  @Test
  public void testFailedCase2() throws Exception {
    final int[] input = new int[] {1,3,1,2,0,5};
    final int[] expected = new int[] {3,3,2,5};
    assertArrayEquals(expected, solution.maxSlidingWindow(input, 3));
  }
}
