package _0151_0200._174_Dungeon_Game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/31/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test3By3() throws Exception {
    final int[][] input = new int[][] {
      {-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}
    };
    assertEquals(7, solution.calculateMinimumHP(input));
  }

}
