package _0251_0300._279_Perfect_Squares;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/3/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test12() throws Exception {
    assertEquals(3, solution.numSquares(12));
  }

  @Test
  public void test13() throws Exception {
    assertEquals(2, solution.numSquares(13));
  }

  @Test
  public void test0() throws Exception {
    assertEquals(0, solution.numSquares(0));
  }

  @Test
  public void test9() throws Exception {
    assertEquals(1, solution.numSquares(9));
  }

  @Test
  public void test625() throws Exception {
    assertEquals(1, solution.numSquares(625));
  }
}
