package interviews.microsoft._125_Valid_Palindrome;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testEmpty() {
    assertTrue(solution.isPalindrome(""));
  }

  @Test
  void test1() {
    assertTrue(solution.isPalindrome("1"));
  }

  @Test
  void test2True() {
    assertTrue(solution.isPalindrome("11"));
  }

  @Test
  void test2False() {
    assertFalse(solution.isPalindrome("12"));
  }

  @Test
  void test3True() {
    assertTrue(solution.isPalindrome("121"));
  }

  @Test
  void test3False() {
    assertFalse(solution.isPalindrome("122"));
  }

  @Test
  void testADot() {
    assertTrue(solution.isPalindrome("a."));
  }

}