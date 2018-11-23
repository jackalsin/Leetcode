package _0651_0700._670_Maximum_Swap;

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
    assertEquals(7236, solution.maximumSwap(2736));
  }

  @Test
  void testOnlineCase2() {
    assertEquals(9972, solution.maximumSwap(9972));
  }

  @Test
  void testOnlineCase3() {
    assertEquals(9972, solution.maximumSwap(9927));
  }

}