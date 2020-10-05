package _0451_0500._452_Minimum_Number_of_Arrows_to_Burst_Balloons;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/29/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
    assertEquals(2, solution.findMinArrowShots(points));
  }

  @Test
  public void testFailedCase() throws Exception {
    final int[][] points = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
    assertEquals(2, solution.findMinArrowShots(points));
  }

  @Test
  public void testFailedCase2() throws Exception {
    final int[][] points = {{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}};
    assertEquals(2, solution.findMinArrowShots(points));
  }

}
