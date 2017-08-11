package _201_250._214_Shortest_Palindrome;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/11/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEmpty() throws Exception {
    assertEquals("", solution.shortestPalindrome(""));
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String input = "aacecaaa";
    final String expected = "aaacecaaa";
    assertEquals(expected, solution.shortestPalindrome(input));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String input = "abcd";
    final String expected = "dcbabcd";
    assertEquals(expected, solution.shortestPalindrome(input));
  }

  @Test
  public void testPalindromeOne() throws Exception {
    final String input = "a";
    final String expected = "a";
    assertEquals(expected, solution.shortestPalindrome(input));
  }

  @Test
  public void testPalindromeTwo() throws Exception {
    final String input = "aa";
    final String expected = "aa";
    assertEquals(expected, solution.shortestPalindrome(input));
  }
}
