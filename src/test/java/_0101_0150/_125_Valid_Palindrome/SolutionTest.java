package _0101_0150._125_Valid_Palindrome;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/26/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEmpty() throws Exception {
    assertTrue(solution.isPalindrome(""));
  }

  @Test
  public void test1() throws Exception {
    assertTrue(solution.isPalindrome("1"));
  }

  @Test
  public void test2True() throws Exception {
    assertTrue(solution.isPalindrome("11"));
  }

  @Test
  public void test2False() throws Exception {
    assertFalse(solution.isPalindrome("12"));
  }

  @Test
  public void test3True() throws Exception {
    assertTrue(solution.isPalindrome("121"));
  }

  @Test
  public void test3False() throws Exception {
    assertFalse(solution.isPalindrome("122"));
  }

  @Test
  public void testADot() throws Exception {
    assertTrue(solution.isPalindrome("a."));
  }

}
