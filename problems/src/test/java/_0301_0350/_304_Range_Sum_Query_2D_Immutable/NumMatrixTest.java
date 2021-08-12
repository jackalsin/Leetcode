package _0301_0350._304_Range_Sum_Query_2D_Immutable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/13/2017.
 */
public class NumMatrixTest {
  private NumMatrix numMatrix;

  @BeforeEach
  public void setUp() throws Exception {
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int[][] input = {
        {3, 0, 1, 4, 2},
        {5, 6, 3, 2, 1},
        {1, 2, 0, 1, 5},
        {4, 1, 0, 1, 7},
        {1, 0, 3, 0, 5}
    };
    numMatrix = new NumMatrix(input);
    assertEquals(8, numMatrix.sumRegion(2, 1, 4, 3));
    assertEquals(11, numMatrix.sumRegion(1, 1, 2, 2));
    assertEquals(12, numMatrix.sumRegion(1, 2, 2, 4));

  }

  @Test
  public void testEmpty2D() throws Exception {
    final int[][] input = {{}};
    numMatrix = new NumMatrix(input);
  }
}
