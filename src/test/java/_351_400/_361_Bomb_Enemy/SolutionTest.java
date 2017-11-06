package _351_400._361_Bomb_Enemy;

import org.junit.Before;
import org.junit.Test;

import utils.TwoDimensionArray;

import static org.junit.Assert.assertEquals;

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
  public void testOnline1() throws Exception {
    final char[][] board = TwoDimensionArray.getCharBoard(new String[] {
        "0E00",
        "E0WE",
        "0E00"
    });

    assertEquals(3, solution.maxKilledEnemies(board));
  }
}
