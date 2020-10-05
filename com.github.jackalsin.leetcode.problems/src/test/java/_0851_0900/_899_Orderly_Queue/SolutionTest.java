package _0851_0900._899_Orderly_Queue;

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
    assertEquals("aaabc", solution.orderlyQueue("baaca", 3));
  }

  @Test
  void testOnlineCase2() {
    assertEquals("acb", solution.orderlyQueue("cba", 1));
  }
}