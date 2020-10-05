package _1051_1100._1056_Confusing_Number;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionITest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionI();
  }

  @Test
  void testOnlineCase1() {
    assertTrue(solution.confusingNumber(6));
  }

  @Test
  void testOnlineCase2() {
    assertTrue(solution.confusingNumber(89));
  }

  @Test
  void testOnlineCase3() {
    assertFalse(solution.confusingNumber(11));
  }

  @Test
  void testOnlineCase4() {
    assertFalse(solution.confusingNumber(25));
  }
}