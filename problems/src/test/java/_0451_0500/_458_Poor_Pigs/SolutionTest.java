package _0451_0500._458_Poor_Pigs;

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
    assertEquals(5, solution.poorPigs(1000, 15, 60));
  }

  @Test
  void testOnlineCase2() {
    assertEquals(10, solution.poorPigs(1000, 60, 60));
  }
}