package interviews.airbnb._125_Valid_Palindrome;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 1/26/2019.
 */
class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testEmpty() throws Exception {
    assertTrue(solution.isPalindrome(""));
  }

  @Test
  void test1() throws Exception {
    assertTrue(solution.isPalindrome("1"));
  }

  @Test
  void test2True() throws Exception {
    assertTrue(solution.isPalindrome("11"));
  }

  @Test
  void test2False() throws Exception {
    assertFalse(solution.isPalindrome("12"));
  }

  @Test
  void test3True() throws Exception {
    assertTrue(solution.isPalindrome("121"));
  }

  @Test
  void test3False() throws Exception {
    assertFalse(solution.isPalindrome("122"));
  }

  @Test
  void testADot() throws Exception {
    assertTrue(solution.isPalindrome("a."));
  }

  @Test
  void testOnlineCase1() {
    assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"));
  }
}