package interviews.linkedin._367_Valid_Perfect_Square;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/23/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  // square N Solution
  @Test
  public void testMissed() throws Exception {
    final int max = Integer.MAX_VALUE;
    assertFalse(solution.squareSolution(max));
  }

  //
  @Test
  public void test16Solution() throws Exception {
    final int num = 16;
    assertTrue(solution.isPerfectSquare(16));
  }
}
