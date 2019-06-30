package interviews.linkedin._125_Valid_Palindrome;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 6/30/2019
 */
class SolutionITest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new SolutionI();
  }

  @Test
  void testOnlineCase1() {
    assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"));
  }

  @Test
  void testOnlineCase2() {
    assertFalse(solution.isPalindrome("race a car"));
  }
}