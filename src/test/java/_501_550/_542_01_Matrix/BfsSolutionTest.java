package _501_550._542_01_Matrix;

import org.junit.Before;
import org.junit.Test;
import utils.TwoDimensionArray;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class BfsSolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new BfsSolution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[][] board = {
        {0, 0, 0},
        {0, 1, 0},
        {0, 0, 0}};
    final int[][] expected = {
        {0, 0, 0},
        {0, 1, 0},
        {0, 0, 0}};
    final int[][] actual = solution.updateMatrix(board);
//    TwoDimensionArray.display2DimensionArray(actual);
    assertTrue(Arrays.deepEquals(expected, actual));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[][] board = {
        {0, 0, 0},
        {0, 1, 0},
        {1, 1, 1}};
    final int[][] expected = {
        {0, 0, 0},
        {0, 1, 0},
        {1, 2, 1}};
    final int[][] actual = solution.updateMatrix(board);
    TwoDimensionArray.display2DimensionArray(actual);
    assertTrue(Arrays.deepEquals(expected, actual));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final int[][] input = {
        {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
        {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
        {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
        {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
        {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
        {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
        {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
        {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};

    final int[][] expected = {
        {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
        {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
        {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
        {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
        {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
        {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
        {1, 0, 0, 0, 1, 2, 1, 1, 0, 1},
        {2, 1, 1, 1, 1, 2, 1, 0, 1, 0},
        {3, 2, 2, 1, 0, 1, 0, 0, 1, 1}};
    final int[][] actual = solution.updateMatrix(input);
    assertTrue(Arrays.deepEquals(expected, actual));
  }
}