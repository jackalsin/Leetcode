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
    solution = new Solution();
  }

  @Test
  public void test4Plus() throws Exception {
    final String input = "++++";
    assertTrue(solution.canWin(input));
  }

  @Test
  public void testEmpty() throws Exception {
    assertFalse(solution.canWin(""));
  }

  // test for getDp()
  @Test
  public void testDp5() throws Exception {
    final int[] actual = Solution.getDp(5);
    final int[] expected = {0, 0, 1, 1, 1, 0};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void testDp9() throws Exception {
    final int[] actual = Solution.getDp(9);
    final int[] expected = {0, 0, 1, 1, 1, 0, 1, 1, 1, 0 };
    assertArrayEquals(expected, actual);
  }
}
