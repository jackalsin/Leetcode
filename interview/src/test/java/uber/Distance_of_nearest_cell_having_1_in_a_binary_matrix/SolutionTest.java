package uber.Distance_of_nearest_cell_having_1_in_a_binary_matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[][] input = {
        {0, 0, 0, 1},
        {0, 0, 1, 1},
        {0, 1, 1, 0}
    };

    final long[][] expected = {
        {3, 2, 1, 0},
        {2, 1, 0, 0},
        {1, 0, 0, 1}
    }, actual = solution.findMinDistance(input);
    assertTrue(Arrays.deepEquals(expected, actual));

  }
}