package interviews.pinterest._498_Diagonal_Traverse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[][] nums = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    final int[] expected = {1, 2, 4, 7, 5, 3, 6, 8, 9};
    assertArrayEquals(expected, solution.findDiagonalOrder(nums));
  }

  @Test
  void testLongCol() {
    final int[][] nums = {
        {1, 2, 3},
        {4, 5, 6}
    };
    final int[] expected = {1, 2, 4, 5, 3, 6};
    assertArrayEquals(expected, solution.findDiagonalOrder(nums));
  }

  @Test
  void testLongRow() {
    final int[][] nums = {
        {1, 2},
        {4, 5},
        {7, 8}
    };
    final int[] expected = {1, 2, 4, 7, 5, 8};
    assertArrayEquals(expected, solution.findDiagonalOrder(nums));
  }
}