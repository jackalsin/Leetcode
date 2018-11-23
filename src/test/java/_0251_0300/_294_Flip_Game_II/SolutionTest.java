package _0251_0300._294_Flip_Game_II;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/6/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
//    solution = new DpSolution();
    solution = new BacktrackingSolution();
  }

  @Test
  void test4Plus() {
    final String input = "++++";
    assertTrue(solution.canWin(input));
  }

  @Test
  void test5Plus() {
    final String input = "+++++";
    assertFalse(solution.canWin(input));
  }

  @Test
  void testEmpty() {
    assertFalse(solution.canWin(""));
  }

}
