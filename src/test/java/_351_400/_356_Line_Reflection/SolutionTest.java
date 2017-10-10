package _351_400._356_Line_Reflection;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/10/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    assertTrue(solution.isReflected(new int[][]{{1, 1}, {-1, 1}}));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    assertFalse(solution.isReflected(new int[][]{{1, 1}, {-1, -1}}));
  }

  @Test
  public void testDuplicatedPoints() throws Exception {
    assertTrue(solution.isReflected(new int[][]{{-16, 1}, {16, 1}, {16, 1}}));
  }

  @Test
  public void testFailedCase() throws Exception {
    assertTrue(solution.isReflected(new int[][]{{1, 1}, {0, 1}, {-1, 1}, {0, 0}}));
  }
}
