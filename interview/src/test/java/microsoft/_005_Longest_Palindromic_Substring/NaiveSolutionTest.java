package microsoft._005_Longest_Palindromic_Substring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/13/2018.
 */
public class NaiveSolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new NaiveSolution();
  }


  @Test
  public void testOnlineCase1() throws Exception {
    final String input = "babad", output = "bab";
    final String actual = solution.longestPalindrome(input);
    assertEquals(output, actual);
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String input = "cbbd", output = "bb";
    assertEquals(output, solution.longestPalindrome(input));
  }

  @Test
  public void testLongestPalindromeOdd() throws Exception {
    final String input = "babad";
    assertArrayEquals(new int[]{0, 0},
        NaiveSolution.longestPalindrome(input.toCharArray(), 0, 0));

    assertArrayEquals(new int[]{0, 2},
        NaiveSolution.longestPalindrome(input.toCharArray(), 1, 1));

  }

  @Test
  public void testLongestPalindromeEven() throws Exception {
    final String input = "babad";
    assertArrayEquals(new int[]{0, 0},
        NaiveSolution.longestPalindrome(input.toCharArray(), 0, 1));

  }

  @Test
  public void testLongestPalindromeEven2() throws Exception {
    final String input = "babad";

    assertArrayEquals(new int[]{1, 3},
        NaiveSolution.longestPalindrome(input.toCharArray(), 2, 2));
  }

  @Test
  public void testFailedCase1() throws Exception {
    assertEquals("a", solution.longestPalindrome("a"));
  }

}
