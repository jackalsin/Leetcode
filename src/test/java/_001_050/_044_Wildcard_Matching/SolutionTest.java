package _001_050._044_Wildcard_Matching;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/23/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithAsteriskNoUse() throws Exception {
    assertTrue(solution.isMatch("ab", "a*b"));
  }

  @Test
  public void testWithAsteriskUsed() throws Exception {
    assertTrue(solution.isMatch("acb", "a*b"));
  }
}