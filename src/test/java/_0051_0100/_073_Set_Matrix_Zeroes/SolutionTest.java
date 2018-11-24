package _0051_0100._073_Set_Matrix_Zeroes;

import org.junit.Before;
import org.junit.Test;
import utils.TwoDimensionArray;

import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 4/30/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEmpty() throws Exception {
    solution.setZeroes(new int[][]{});
  }

  @Test
  public void test5By5() throws Exception {
    int[][] input = new int[][]{
        {1, 0, 3, 5},
        {0, 1, 3, 4},
        {2, 1, 0, 4},
        {4, 1, 3, 4}
    };
    solution.setZeroes(input);
    int[][] expected = new int[][]{
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 4}
    };
    assertTrue(TwoDimensionArray.TwoDimensionArrayEquals(expected, input));
  }

  @Test
  public void test2By3() throws Exception {
    int[][] input = new int[][]{{1, 1, 1}, {0, 1, 2}};
    solution.setZeroes(input);
    int[][] expected = new int[][]{
        {0, 1, 1},
        {0, 0, 0}
    };
    assertTrue(TwoDimensionArray.TwoDimensionArrayEquals(input, expected));

  }

  @Test
  public void test3By5() throws Exception {
    int[][] input = new int[][]{
        {-4, -2147483648, 6, -7, 0},
        {-8, 6, -8, -6, 0},
        {2147483647, 2, -9, -6, -10}
    };
    solution.setZeroes(input);
    int[][] expected = new int[][]{
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {2147483647, 2, -9, -6, 0}
    };
    assertTrue(TwoDimensionArray.TwoDimensionArrayEquals(input, expected));

  }
}