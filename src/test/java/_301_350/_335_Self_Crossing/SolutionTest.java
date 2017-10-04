package _301_350._335_Self_Crossing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 10/3/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] input = {2, 1, 1, 2};
    assertTrue(solution.isSelfCrossing(input));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] input = {1, 2, 3, 4};
    assertFalse(solution.isSelfCrossing(input));
  }

  @Test
  public void testOnlineCase3() throws Exception {
    final int[] input = {1, 1, 1, 1};
    assertTrue(solution.isSelfCrossing(input));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final int[] input = {3,3,3,2,1,1};
    assertFalse(solution.isSelfCrossing(input));
  }

}
