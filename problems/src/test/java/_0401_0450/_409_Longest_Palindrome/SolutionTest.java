package _0401_0450._409_Longest_Palindrome;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/12/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
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
