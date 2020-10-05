package google._296_Best_Meeting_Point;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/14/2018.
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
