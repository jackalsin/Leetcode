package _0501_0550._542_01_Matrix;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
//    solution = new BfsSolution();
    solution = new TwoSweepSolution();
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

  @Test
  public void testFailedCase2() {

    final int[][] input = {
        {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 0, 0, 0, 1, 1, 0},
        {1, 1, 1, 1, 1, 1, 0, 0, 1, 0},
        {1, 0, 0, 1, 1, 1, 0, 1, 0, 1},
        {0, 0, 1, 0, 0, 1, 1, 0, 0, 1},
        {0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 1, 1, 0, 0, 0, 0, 0},
        {0, 0, 1, 1, 1, 1, 0, 1, 1, 1},
        {1, 1, 0, 0, 1, 0, 1, 0, 1, 1}};

    final int[][] expected = {
        {2, 1, 0, 1, 2, 2, 2, 3, 3, 2},
        {2, 1, 0, 1, 1, 1, 1, 2, 2, 1},
        {3, 2, 1, 1, 0, 0, 0, 1, 1, 0},
        {2, 1, 1, 2, 1, 1, 0, 0, 1, 0},
        {1, 0, 0, 1, 1, 1, 0, 1, 0, 1},
        {0, 0, 1, 0, 0, 1, 1, 0, 0, 1},
        {0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 1, 1, 0, 0, 0, 0, 0},
        {0, 0, 1, 1, 2, 1, 0, 1, 1, 1},
        {1, 1, 0, 0, 1, 0, 1, 0, 1, 2}
    };


    final int[][] actual = solution.updateMatrix(input);
    assertTrue(Arrays.deepEquals(expected, actual));

  }
}