package _0851_0900._898_Bitwise_ORs_of_Subarrays;

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
    assertEquals(1, solution.subarrayBitwiseORs(new int[]{1}));
  }

  @Test
  void testOnlineCase2() {
    assertEquals(3, solution.subarrayBitwiseORs(new int[]{1, 1, 2}));
  }

  @Test
  void testOnlineCase3() {
    assertEquals(6, solution.subarrayBitwiseORs(new int[]{1, 2, 4}));
  }
}