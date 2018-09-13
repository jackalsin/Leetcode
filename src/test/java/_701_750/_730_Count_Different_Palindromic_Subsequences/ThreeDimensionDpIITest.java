package _701_750._730_Count_Different_Palindromic_Subsequences;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/13/18
 */
class ThreeDimensionDpIITest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new ThreeDimensionDpII();
  }

  @Test
  void testOnlineCase1() {
    final String input = "bccb";
    assertEquals(6, solution.countPalindromicSubsequences(input));
  }

  @Test
  void testOnlineCase2() {
    final String input = "abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba";
    assertEquals(104860361, solution.countPalindromicSubsequences(input));
  }

  @Test
  void testOnlineCase3() {
    final String input = "abcb";
    assertEquals(5, solution.countPalindromicSubsequences(input));
  }

}