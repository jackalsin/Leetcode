package _0601_0650._633_Sum_of_Square_Numbers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    assertFalse(solution.judgeSquareSum(3));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    assertTrue(solution.judgeSquareSum(5));
  }

  @Test
  public void test25() throws Exception {
    assertTrue(solution.judgeSquareSum(25));
  }

}
