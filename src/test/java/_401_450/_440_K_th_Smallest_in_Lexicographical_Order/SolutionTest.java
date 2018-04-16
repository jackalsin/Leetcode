package _401_450._440_K_th_Smallest_in_Lexicographical_Order;

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
    assertEquals(10, solution.findKthNumber(13, 2));
  }

  @Test
  void testOnlineCase2() {
    assertEquals(116, solution.findKthNumber(220, 20));
  }
}