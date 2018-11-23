package _0351_0400._363_Max_Sum_of_Rectangle_No_Larger_Than_K;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 11/6/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[][] matrix = new int[][] {
        {1, 0, 1},
        {0, -2, 3}
    };

    assertEquals(2, solution.maxSumSubmatrix(matrix, 2));
  }
}
