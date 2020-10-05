package uber._202_Happy_Number;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
//    solution = new HashSetSolution();
    solution = new FloydCycleAlgorithmSolution();
  }

  @Test
  void testIsHappy() {
    assertTrue(solution.isHappy(19));
  }

  @Test
  void test887() {
    assertFalse(solution.isHappy(887));
  }

}