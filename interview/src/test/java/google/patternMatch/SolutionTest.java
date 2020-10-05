package google.patternMatch;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 1/9/2018.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String str1 = "aoczzz", str2 = "bocabc";
    final String pattern = "1oc3";

    assertTrue(solution.patternMatch(str1, pattern));
    assertTrue(solution.patternMatch(str2, pattern));
  }
}
