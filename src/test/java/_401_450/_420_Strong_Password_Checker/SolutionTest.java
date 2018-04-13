package _401_450._420_Strong_Password_Checker;

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
    // a: 2, bb: 2, cc: 2, d: 5
    final String s = "aabbccddddd";
    assertEquals(2, solution.strongPasswordChecker(s));
  }

  @Test
  void testOnlineCase2() {
    final String s = "1234567890123456Baaaaa";
//    final String   "1234567890123456BaAa"; // delete 2 and replace 1
    assertEquals(3, solution.strongPasswordChecker(s));
  }
}