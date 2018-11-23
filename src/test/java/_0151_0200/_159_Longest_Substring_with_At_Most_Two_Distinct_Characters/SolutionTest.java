package _0151_0200._159_Longest_Substring_with_At_Most_Two_Distinct_Characters;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/23/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEmpty() throws Exception {
    assertEquals(0, solution.lengthOfLongestSubstringTwoDistinct(""));
  }

  @Test
  public void testOneElement() throws Exception {
    assertEquals(1, solution.lengthOfLongestSubstringTwoDistinct("c"));
  }

  @Test
  public void testOneDuplicatedElement() throws Exception {
    assertEquals(5, solution.lengthOfLongestSubstringTwoDistinct("ccccc"));
  }

  @Test
  public void testTwoElements() throws Exception {
    assertEquals(6, solution.lengthOfLongestSubstringTwoDistinct("ceecce"));
  }

  @Test
  public void testThreeElements() throws Exception {
    assertEquals(3, solution.lengthOfLongestSubstringTwoDistinct("eceba"));
  }

  @Test
  public void testThreeElementsLast() throws Exception {
    assertEquals(5, solution.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
  }
}
