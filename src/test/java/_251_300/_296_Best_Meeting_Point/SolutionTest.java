package _251_300._296_Best_Meeting_Point;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 9/9/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test11() throws Exception {
    final int[][] board = {{1, 1}};
    assertEquals(1, solution.minTotalDistance(board));
  }

}
