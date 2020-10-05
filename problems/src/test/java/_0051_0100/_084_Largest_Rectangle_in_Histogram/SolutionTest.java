package _0051_0100._084_Largest_Rectangle_in_Histogram;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/21/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int[] heights = new int[]{2, 1, 5, 6, 2, 3};
    assertEquals(10, solution.largestRectangleArea(heights));
  }

  @Test
  public void testLastIsBig() throws Exception {
    final int[] heights = new int[]{0};
    assertEquals(0, solution.largestRectangleArea(heights));
  }
}