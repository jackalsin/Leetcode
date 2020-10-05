package dynamicProgramming._005_Longest_Palindromic_Substring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  private static final String ABCD = "abcd";
  private static final String ABBA = "abba";
  private static final String ACA = "aca";
  private static final String ABCDAD = "abcdad";

  @Test
  void longestPalindromeEndOddAnswer() {
    assertEquals("dad", solution.longestPalindrome(ABCDAD));
  }

  @Test
  void longestPalindromeFullOddAnswer() {
    assertEquals("aca", solution.longestPalindrome(ACA));
  }

  @Test
  void longestPalindromeFullEvenAnswer() {
    assertEquals("abba", solution.longestPalindrome(ABBA));
  }

  @Test
  void longestPalindromeSingleCharAnswer() {
    Set<String> ans = new HashSet<>(Arrays.asList("a", "b", "c", "d"));
    String expect = solution.longestPalindrome(ABCD);
    assertTrue(ans.contains(expect));
  }
}