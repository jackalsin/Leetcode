package facebook._308_Range_Sum_Query_2D_Mutable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumMatrixTest {
  private static final int[][] INPUT_1 = {
      {3, 0, 1, 4, 2},
      {5, 6, 3, 2, 1},
      {1, 2, 0, 1, 5},
      {4, 1, 0, 1, 7},
      {1, 0, 3, 0, 5}
  };
  private NumMatrix numMatrix;

  @BeforeEach
  void setUp() {
    numMatrix = new NumMatrix(INPUT_1);
  }

  @Test
  void testOnline() {
    assertEquals(8, numMatrix.sumRegion(2, 1, 4, 3));
    numMatrix.update(3, 2, 2);
    assertEquals(10, numMatrix.sumRegion(2, 1, 4, 3));
  }

  @Test
  void testEmpty() {
    numMatrix = new NumMatrix(new int[][]{});
  }
}