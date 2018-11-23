package _0451_0500._498_Diagonal_Traverse;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[][] nums = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    final int[] expected = {1, 2, 4, 7, 5, 3, 6, 8, 9};
    assertArrayEquals(expected, solution.findDiagonalOrder(nums));
  }
}