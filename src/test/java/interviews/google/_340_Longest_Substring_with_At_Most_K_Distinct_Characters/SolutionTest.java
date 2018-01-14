package interviews.google._340_Longest_Substring_with_At_Most_K_Distinct_Characters;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/13/2018.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    assertEquals(3, solution.lengthOfLongestSubstringKDistinct("eceba", 2));
  }

  @Test
  public void testFailedCase1() throws Exception {
    assertEquals(0, solution.lengthOfLongestSubstringKDistinct("a", 0));
  }

  @Test
  public void testFailedCase2() throws Exception {
    assertEquals(3, solution.lengthOfLongestSubstringKDistinct("bacc", 2));
  }
}
