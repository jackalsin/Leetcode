package _1001_1050._1015_Numbers_With_1_Repeated_Digit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    assertEquals(1, solution.numDupDigitsAtMostN(20));
  }

  @Test
  void testOnlineCase2() {
    assertEquals(10, solution.numDupDigitsAtMostN(100));
  }

  @Test
  void testOnlineCase3() {
    assertEquals(262, solution.numDupDigitsAtMostN(1000));
  }
}