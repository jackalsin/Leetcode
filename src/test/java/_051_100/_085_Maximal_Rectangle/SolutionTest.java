package _051_100._085_Maximal_Rectangle;

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
    final char[][] board = new char[][] {
        {'0', '0', '0', '1', '0', '0', '0'},
        {'0', '0', '1', '1', '1', '0', '0'},
        {'0', '1', '1', '1', '1', '1', '0'}
    };

    assertEquals(6, solution.maximalRectangle(board));
  }

}