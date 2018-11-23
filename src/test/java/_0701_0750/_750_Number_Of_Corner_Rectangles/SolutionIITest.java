package _0701_0750._750_Number_Of_Corner_Rectangles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIITest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new SolutionII();
  }

  @Test
  void testOnlineCase1() {
    final int[][] nums = {
        {1, 0, 0, 1, 0},
        {0, 0, 1, 0, 1},
        {0, 0, 0, 1, 0},
        {1, 0, 1, 0, 1}
    };
    assertEquals(1, solution.countCornerRectangles(nums));
  }

  @Test
  void testOnlineCase2() {
    final int[][] nums = {
        {1, 1, 1},
        {1, 1, 1},
        {1, 1, 1}
    };
    assertEquals(9, solution.countCornerRectangles(nums));
  }

  @Test
  void testOnlineCase3() {
    final int[][] nums = {{1, 1, 1, 1}};
    assertEquals(0, solution.countCornerRectangles(nums));
  }

}