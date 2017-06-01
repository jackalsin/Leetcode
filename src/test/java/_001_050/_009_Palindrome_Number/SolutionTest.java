package _001_050._009_Palindrome_Number;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2017/1/13.
 */
public class SolutionTest {

  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testMinValue() throws Exception {
    assertFalse(solution.isPalindrome(Integer.MIN_VALUE));
  }

  @Test
  public void testMaxValue() throws Exception {
    assertFalse(solution.isPalindrome(Integer.MAX_VALUE));
  }

  @Test
  public void testZero() throws Exception {
    assertTrue(solution.isPalindrome(0));
  }

  @Test
  public void testSingleDigit() throws Exception {
    assertTrue(solution.isPalindrome(1));
  }

  @Test
  public void testTwoDigits() throws Exception {
    assertTrue(solution.isPalindrome(11));
  }

  @Test
  public void testThreeDigits() throws Exception {
    assertTrue(solution.isPalindrome(121));
  }

  @Test
  public void testFourDigits() throws Exception {
    assertTrue(solution.isPalindrome(1221));
  }
}