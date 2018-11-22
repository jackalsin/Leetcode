package _901_950._939_Minimum_Area_Rectangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new DiagonalSolution();
  }

  @Test
  void testOnlineCase1() {
    final int[][] input = {
        {1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}
    };
    assertEquals(4, solution.minAreaRect(input));
  }

  @Test
  void testOnlineCase2() {
    final int[][] input = {
        {1, 1}, {1, 3}, {3, 1}, {3, 3}, {4, 1}, {4, 3}
    };
    assertEquals(2, solution.minAreaRect(input));
  }
}