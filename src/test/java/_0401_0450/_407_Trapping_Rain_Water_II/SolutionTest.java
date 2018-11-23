package _0401_0450._407_Trapping_Rain_Water_II;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[][] heightMap = {
        {1, 4, 3, 1, 3, 2},
        {3, 2, 1, 3, 2, 4},
        {2, 3, 3, 2, 3, 1}
    };
    assertEquals(4, solution.trapRainWater(heightMap));
  }

  @Test
  public void testSurroundingHoleOnEdge() throws Exception {
    final int[][] heightMap = {
        {9, 0, 9, 9, 9, 9},
        {9, 8, 0, 0, 0, 9},
        {9, 9, 9, 9, 9, 9}
    };
    assertEquals(24, solution.trapRainWater(heightMap));
  }


  @Test
  public void testOtherSideIsLower() throws Exception {
    final int[][] heightMap = {
        {9, 0, 9, 9, 9, 9},
        {9, 8, 0, 0, 0, 9},
        {9, 9, 9, 9, 5, 9}
    };
    assertEquals(15, solution.trapRainWater(heightMap));
  }
}