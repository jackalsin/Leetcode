package uber.solveEquation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
  private Solution solution;
  private static final double BIAS = 1E-9;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final String s = "2x - ((x - (3x + 1) + 2) + 3) + 4 = x + y";
    assertEquals(3d, solution.solve(s, 1), BIAS);
  }
}