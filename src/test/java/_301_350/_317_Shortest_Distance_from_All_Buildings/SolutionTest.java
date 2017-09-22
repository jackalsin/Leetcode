package _301_350._317_Shortest_Distance_from_All_Buildings;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 9/22/2017.
 */
public class SolutionTest {
  private Solution solution;
  private static final int[][] NORMAL_BOARD = {
      {1, 0, 2, 0, 1},
      {0, 0, 0, 0, 0},
      {0, 0, 1, 0, 0}
  };

  private static final int[][] surroundingBoard = {

  };

  private static final int[][] FULL_BUILDING_BOARD_1_BY_1 = {{1}};
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testNormalCase() throws Exception {
    assertEquals(7, solution.shortestDistance(NORMAL_BOARD));
  }

  @Test
  public void testFullBuildingBoard1By1() throws Exception {
    assertEquals(-1, solution.shortestDistance(FULL_BUILDING_BOARD_1_BY_1));
  }
}
