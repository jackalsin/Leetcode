package _0351_0400._360_Sort_Transformed_Array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 11/5/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] input = {-4, -2, 2, 4};
    assertArrayEquals(new int[]{3, 9, 15, 33},
        solution.sortTransformedArray(input, 1, 3, 5));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] input = {-4, -2, 2, 4};
    assertArrayEquals(new int[]{-23, -5, 1, 7},
        solution.sortTransformedArray(input, -1, 3, 5));

  }

  @Test
  public void testAEquals() throws Exception {
    final int[] input = {-4, -2, 2, 4};
    assertArrayEquals(new int[]{1, 3, 7, 9},
        solution.sortTransformedArray(input, 0, -1, 5));

  }

  @Test
  public void testFailedCase1() throws Exception {
    final int[] input = {-4, -2, 2, 4};
    assertArrayEquals(new int[]{-7, -1, 11, 17},
        solution.sortTransformedArray(input, 0, 3, 5));
  }
}
