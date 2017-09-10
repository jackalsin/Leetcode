package _251_300._294_Flip_Game_II;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/6/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
//    solution = new DpSolution();
    solution = new BacktrackingSolution();
  }

  @Test
  public void test4Plus() throws Exception {
    final String input = "++++";
    assertTrue(solution.canWin(input));
  }

  @Test
  public void test5Plus() throws Exception {
    final String input = "+++++";
    assertFalse(solution.canWin(input));
  }

  @Test
  public void testEmpty() throws Exception {
    assertFalse(solution.canWin(""));
  }

}
