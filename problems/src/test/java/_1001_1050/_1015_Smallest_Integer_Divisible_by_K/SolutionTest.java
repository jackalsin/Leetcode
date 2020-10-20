package _1001_1050._1015_Smallest_Integer_Divisible_by_K;

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
    assertEquals(1, solution.smallestRepunitDivByK(1));
  }

  @Test
  void testOnlineCase2() {
    assertEquals(-1, solution.smallestRepunitDivByK(2));
  }

  @Test
  void testOnlineCase3() {
    assertEquals(3, solution.smallestRepunitDivByK(3));
  }

  @Test
  void testOnlineCase4() {
    assertEquals(16, solution.smallestRepunitDivByK(17));
  }
}