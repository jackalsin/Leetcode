package _351_400._367_Valid_Perfect_Square;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/14/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase16() throws Exception {
    assertTrue(solution.isPerfectSquare(16));
  }

  @Test
  public void testOnlineCase14() throws Exception {
    assertFalse(solution.isPerfectSquare(14));
  }

  @Test
  public void testZero() throws Exception {
    assertFalse(solution.isPerfectSquare(0));
  }

  @Test
  public void test2147483647() throws Exception {
    assertFalse(solution.isPerfectSquare(2147483647));
  }
}
