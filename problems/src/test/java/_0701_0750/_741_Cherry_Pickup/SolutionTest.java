package _0701_0750._741_Cherry_Pickup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/21/2018.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[][] grid = {
        {0, 1, -1},
        {1, 0, -1},
        {1, 1, 1}
    };
    assertEquals(5, solution.cherryPickup(grid));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final int[][] grid = {
        {1, 1, -1},
        {1, -1, 1},
        {-1, 1, 1}
    };
    assertEquals(0, solution.cherryPickup(grid));
  }

}
