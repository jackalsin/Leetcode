package _1001_1050._1014_Capacity_To_Ship_Packages_Within_D_Days;

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
    final int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    assertEquals(15, solution.shipWithinDays(input, 5));
  }

  @Test
  void testOnlineCase2() {
    final int[] input = {3, 2, 2, 4, 1, 4};
    assertEquals(6, solution.shipWithinDays(input, 3));
  }

  @Test
  void testOnlineCase3() {
    final int[] input = {1, 2, 3, 1, 1};
    assertEquals(3, solution.shipWithinDays(input, 4));
  }
}