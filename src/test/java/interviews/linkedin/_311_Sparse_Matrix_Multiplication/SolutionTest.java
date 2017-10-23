package interviews.linkedin._311_Sparse_Matrix_Multiplication;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import _301_350._311_Sparse_Matrix_Multiplication.Solution;

import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public class SolutionTest {
  private _301_350._311_Sparse_Matrix_Multiplication.Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int[][] A = {
        {1, 0, 0},
        {-1, 0, 3}
    };
    final int[][] B = {
        {7, 0, 0},
        {0, 0, 0},
        {0, 0, 1}
    };

    final int[][] C = {{7, 0, 0}, {-7, 0, 3}};
    assertTrue(Arrays.deepEquals(C, solution.multiply(A, B)));

  }

}
