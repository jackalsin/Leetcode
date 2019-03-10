package _1001_1050._1006_Clumsy_Factorial;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/10/2019.
 */
class O1SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new O1Solution();
  }

  @Test
  void testOnlineCase1() {
    assertEquals(7, solution.clumsy(4));
  }

  @Test
  void testOnlineCase2() {
    assertEquals(12, solution.clumsy(10));
  }

  @Test
  void testOnlineCase3() {
    assertEquals(10, solution.clumsy(11));
  }
}