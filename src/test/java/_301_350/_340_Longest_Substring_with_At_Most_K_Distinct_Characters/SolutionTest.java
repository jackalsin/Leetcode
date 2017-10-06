package _301_350._340_Longest_Substring_with_At_Most_K_Distinct_Characters;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/5/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final String s = "eceba";
    assertEquals(3, solution.lengthOfLongestSubstringKDistinct(s, 2));
  }

  @Test
  public void testKEquals0() throws Exception {
    final String s = "abaccc";
    assertEquals(4, solution.lengthOfLongestSubstringKDistinct(s, 2));
  }
}
