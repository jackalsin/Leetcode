package _401_450._413_Arithmetic_Slices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
//    solution = new Dp2dSolution();
    solution = new Dp1DSolution();
  }

  @Test
  void testOnlineCase1() {
    final int[] A = {1, 2, 3, 4};
    assertEquals(3, solution.numberOfArithmeticSlices(A));
  }

  @Test
  void testFailedCase1() {
    final int[] A = {1, 2, 3, 4, 5, 6};
    assertEquals(10, solution.numberOfArithmeticSlices(A));
  }

}