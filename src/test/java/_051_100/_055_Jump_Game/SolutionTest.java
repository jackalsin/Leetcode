package _051_100._055_Jump_Game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 4/20/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithOnlineCase1() throws Exception {
    assertTrue(solution.canJump(new int[] {2,3,1,1,4}));
  }


  @Test
  public void testWithOnlineCase2() throws Exception {
    assertFalse(solution.canJump(new int[] {3, 2, 1, 0, 4}));
  }

  @Test
  public void testWithOnlineCase3() throws Exception {
    assertTrue(solution.canJump(new int[] {1, 2, 3}));
  }
}