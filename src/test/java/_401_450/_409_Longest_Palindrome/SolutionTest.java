package _401_450._409_Longest_Palindrome;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/12/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testAdccba() throws Exception {
    final String input = "adccba";
    assertEquals(5, solution.longestPalindrome(input));
  }

  @Test
  public void testEmpty() throws Exception {
    assertEquals(0, solution.longestPalindrome(""));
  }

}
