package _0101_0150._115_Distinct_Subsequences;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 6/25/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final String s = "rabbbit";
    final String t = "rabbit";
    assertEquals(3, solution.numDistinct(s, t));
  }

}