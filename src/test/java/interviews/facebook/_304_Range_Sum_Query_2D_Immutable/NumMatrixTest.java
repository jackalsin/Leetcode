package interviews.facebook._304_Range_Sum_Query_2D_Immutable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumMatrixTest {
  @Test
  void testOnlineCase1() {
    final int[][] matrix = {
        {3, 0, 1, 4, 2},
        {5, 6, 3, 2, 1},
        {1, 2, 0, 1, 5},
        {4, 1, 0, 1, 7},
        {1, 0, 3, 0, 5}
    };

    NumMatrix solution = new NumMatrix(matrix);
    assertEquals(8, solution.sumRegion(2, 1, 4, 3));
    assertEquals(11, solution.sumRegion(1, 1, 2, 2));
    assertEquals(12, solution.sumRegion(1, 2, 2, 4));
  }
}