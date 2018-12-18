package _0801_0850._818_Race_Car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BfsSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new BfsSolution();
  }

  @Test
  void testOnlineCase1() {
    assertEquals(2, solution.racecar(3));
  }

  @Test
  void testOnlineCase2() {
    assertEquals(5, solution.racecar(6));
  }

  @Test
  void testOnlineCase3() {
    assertEquals(7, solution.racecar(5));
  }
}