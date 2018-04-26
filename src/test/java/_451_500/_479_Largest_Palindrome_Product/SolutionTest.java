package _451_500._479_Largest_Palindrome_Product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    assertEquals(9, solution.largestPalindrome(1));
  }

  @Test
  void testOnlineCase2() {
    assertEquals(987, solution.largestPalindrome(2));
  }

  @Test
  void testOnlineCase3() {
    assertEquals(123, solution.largestPalindrome(3));
  }

  @Test
  void testOnlineCase4() {
    assertEquals(597, solution.largestPalindrome(4));
  }

  @Test
  void testOnlineCase5() {
    assertEquals(677, solution.largestPalindrome(5));
  }

  @Test
  void testOnlineCase6() {
    assertEquals(1218, solution.largestPalindrome(6));
  }
}