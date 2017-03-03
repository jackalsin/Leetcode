package _001_050._005_Longest_Palindromic_Substring;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2017/1/11.
 */
public class SolutionTest {

  private static final String ABCD = "abcd";
  private static final String ABBA = "abba";
  private static final String ACA = "aca";
  private static final String ABCDAD = "abcdad";
  private final Solution solution = new Solution();

  @Test
  public void longestPalindromeEndOddAnswer() {
    assertEquals("dad", solution.longestPalindrome(ABCDAD));
  }

  @Test
  public void longestPalindromeFullOddAnswer() {
    assertEquals("aca", solution.longestPalindrome(ACA));
  }

  @Test
  public void longestPalindromeFullEvenAnswer() {
    assertEquals("abba", solution.longestPalindrome(ABBA));
  }

  @Test
  public void longestPalindromeSingleCharAnswer() {
    Set<String> ans = new HashSet<>(Arrays.asList("a", "b", "c", "d"));
    String expect = solution.longestPalindrome(ABCD);
    assertTrue(ans.contains(expect));
  }

}