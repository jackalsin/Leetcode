package _0051_0100._059_Spiral_Matrix_II;

import org.junit.Before;
import org.junit.Test;
import utils.TwoDimensionArray;

import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 4/22/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWith1() throws Exception {
    int[][] expected = new int[][]{{1}};
    assertTrue(TwoDimensionArray.TwoDimensionArrayEquals(expected, solution.generateMatrix(1)));
  }

  @Test
  public void testWith2() throws Exception {
    int[][] expected = new int[][]{{1, 2}, {4, 3}};
    assertTrue(TwoDimensionArray.TwoDimensionArrayEquals(expected, solution.generateMatrix(2)));
  }


  @Test
  public void testWith3() throws Exception {
    int[][] expected = new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
    assertTrue(TwoDimensionArray.TwoDimensionArrayEquals(expected, solution.generateMatrix(3)));
  }
}