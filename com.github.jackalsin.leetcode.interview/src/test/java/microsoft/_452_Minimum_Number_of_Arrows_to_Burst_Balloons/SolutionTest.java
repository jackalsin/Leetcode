package microsoft._452_Minimum_Number_of_Arrows_to_Burst_Balloons;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() throws Exception {
    final int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
    assertEquals(2, solution.findMinArrowShots(points));
  }

  @Test
  void testFailedCase() throws Exception {
    final int[][] points = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
    assertEquals(2, solution.findMinArrowShots(points));
  }

  @Test
  void testFailedCase2() throws Exception {
    final int[][] points = {{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}};
    assertEquals(2, solution.findMinArrowShots(points));
  }

}