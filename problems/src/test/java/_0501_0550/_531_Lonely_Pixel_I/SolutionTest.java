package _0501_0550._531_Lonely_Pixel_I;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
//    solution = new OMNSpaceSolution();
    solution = new O1SpaceSolution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final char[][] board = {
        {'W', 'W', 'B'},
        {'W', 'B', 'W'},
        {'B', 'W', 'W'}
    };

    assertEquals(3, solution.findLonelyPixel(board));
  }


  @Test
  public void testDupCol() {
    final char[][] board = {
        {'W', 'B', 'W'},
        {'W', 'B', 'W'},
        {'B', 'W', 'W'}
    };

    assertEquals(1, solution.findLonelyPixel(board));
  }

  @Test
  public void testDupRow() {
    final char[][] board = {
        {'W', 'B', 'B'},
        {'W', 'W', 'W'},
        {'B', 'W', 'W'}
    };

    assertEquals(1, solution.findLonelyPixel(board));
  }
}