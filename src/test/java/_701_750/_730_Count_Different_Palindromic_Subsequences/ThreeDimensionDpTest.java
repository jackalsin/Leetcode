package _701_750._730_Count_Different_Palindromic_Subsequences;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 1/14/2018.
 */
public class ThreeDimensionDpTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new ThreeDimensionDp();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String input ="bccb";
    assertEquals(6, solution.countPalindromicSubsequences(input));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String input ="abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba";
    assertEquals(104860361, solution.countPalindromicSubsequences(input));
  }
}
