package _0251_0300._256_Paint_House;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/25/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEmpty() throws Exception {
    final int[][] costs = new int[][] {};
    assertEquals(0, solution.minCost(costs));
  }
  @Test
  public void testOne() throws Exception {
    final int[][] costs = new int[][] {{7, 2, 6}};
    assertEquals(2, solution.minCost(costs));
  }

  @Test
  public void testNormal() throws Exception {
    final int[][] costs = new int[][] {
        {4, 5, 6},
        {1, 20, 21}
    };
    assertEquals(6, solution.minCost(costs));
  }

  @Test
  public void testNormal2() throws Exception {
    final int[][] costs = new int[][] {
        {4, 5, 6},
        {1, 20, 21},
        {2, 20, 21}
    };
    assertEquals(26, solution.minCost(costs));
  }
  @Test
  public void testNormal3() throws Exception {
    final int[][] costs = new int[][] {
        {17, 2, 17},
        {16, 16, 5},
        {14, 3, 19}
    };
    assertEquals(10, solution.minCost(costs));
  }

}
