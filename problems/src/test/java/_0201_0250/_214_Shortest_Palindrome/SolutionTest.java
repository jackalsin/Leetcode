package _0201_0250._214_Shortest_Palindrome;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/11/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
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

  // test genTable
  @Test
  public void testGenTable()throws Exception {
    final String pattern = "ABCDABD";
    final int[] expected = new int[] {0, 0, 0, 0, 1, 2, 0};
    assertArrayEquals(expected, solution.genTable(pattern));
  }
}
