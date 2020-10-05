package _0051_0100._052_N_Queens_II;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/26/2017.
 */
public class SolutionTest {

  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWith1() throws Exception {
    assertEquals(1, solution.totalNQueens(1));
  }

  @Test
  public void testWith2() throws Exception {
    assertEquals(0, solution.totalNQueens(2));
  }

  @Test
  public void testWith3() throws Exception {
    assertEquals(0, solution.totalNQueens(3));
  }

  @Test
  public void testWith4() throws Exception {
    assertEquals(2, solution.totalNQueens(4));
  }

}