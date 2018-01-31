package interviews.google._308_Range_Sum_Query_2D_Mutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/30/2018.
 */
public class NumMatrixTest {

  private static final int[][] INPUT_1 = {
      {3, 0, 1, 4, 2},
      {5, 6, 3, 2, 1},
      {1, 2, 0, 1, 5},
      {4, 1, 0, 1, 7},
      {1, 0, 3, 0, 5}
  };
  private NumMatrix numMatrix;

  @Before
  public void setUp() throws Exception {
    numMatrix = new NumMatrix(INPUT_1);
  }

  @Test
  public void testOnline() throws Exception {
    assertEquals(8, numMatrix.sumRegion(2, 1, 4, 3));
    numMatrix.update(3, 2, 2);
    assertEquals(10, numMatrix.sumRegion(2, 1, 4, 3));
  }

  @Test
  public void testEmpty() throws Exception {
    numMatrix = new NumMatrix(new int[][] {});
  }
}
