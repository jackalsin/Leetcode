package _0501_0550._533_Lonely_Pixel_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final char[][] board = {
        {'W', 'B', 'W', 'B', 'B', 'W'},
        {'W', 'B', 'W', 'B', 'B', 'W'},
        {'W', 'B', 'W', 'B', 'B', 'W'},
        {'W', 'W', 'B', 'W', 'B', 'W'}
    };
    assertEquals(6, solution.findBlackPixel(board, 3));

  }
}