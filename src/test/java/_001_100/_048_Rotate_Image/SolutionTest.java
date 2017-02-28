package _001_100._048_Rotate_Image;

import org.junit.Before;
import org.junit.Test;

import utils.TwoDimensionArray;

import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/28/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithEmptySquare() throws Exception {
    int[][] actual = new int[][]{};
    solution.rotate(actual);
    assertTrue(TwoDimensionArray.TwoDimensionArrayEquals(new int[][]{}, actual));
  }

  @Test
  public void testWithSingleElementSquare() throws Exception {
    int[][] expected = new int[][]{{1}};
    int[][] actual = new int[][]{{1}};
    solution.rotate(actual);
    assertTrue(TwoDimensionArray.TwoDimensionArrayEquals(expected, actual));
  }

  @Test
  public void testWith2by2Matrix() throws Exception {
    int[][] expected = new int[][]{{3, 1}, {4, 2}};
    int[][] actual = new int[][]{{1, 2}, {3, 4}};
    solution.rotate(actual);
    TwoDimensionArray.display2DimensionArray(actual);
    assertTrue(TwoDimensionArray.TwoDimensionArrayEquals(expected, actual));
  }

  @Test
  public void testWith4by4Matrix() throws Exception {
    int[][] expected = new int[][]{{13, 9, 5, 1},
                                    {14, 10, 6, 2},
                                    {15, 11, 7, 3},
                                    {16, 12, 8, 4}};
    int[][] actual = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    solution.rotate(actual);
    TwoDimensionArray.display2DimensionArray(actual);
    assertTrue(TwoDimensionArray.TwoDimensionArrayEquals(expected, actual));
  }
}