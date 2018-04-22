package _451_500._455_Assign_Cookies;

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
    final int[] g = {1, 2, 3}, s = {1, 1};
    assertEquals(1, solution.findContentChildren(g, s));
  }

  @Test
  void testOnlineCase2() {
    final int[] g = {1, 2}, s = {1, 2, 3};
    assertEquals(2, solution.findContentChildren(g, s));
  }
}
