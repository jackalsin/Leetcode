package _0351_0400._361_Bomb_Enemy;

import definition.TwoDimensionArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/5/2017.
 */
public class SolutionITest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new SolutionI();
  }

  @Test
  public void testOnline1() throws Exception {
    final char[][] board = TwoDimensionArray.getCharBoard(new String[]{
        "0E00",
        "E0WE",
        "0E00"
    });

    assertEquals(3, solution.maxKilledEnemies(board));
  }
}
