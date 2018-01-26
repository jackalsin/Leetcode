package interviews.google._766_Toeplitz_Matrix;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * @author jacka
 * @version 1.0 on 1/25/2018.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[][] matrix = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
    assertTrue(solution.isToeplitzMatrix(matrix));

  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[][] matrix = {{1, 2}, {2, 2}};
    assertFalse(solution.isToeplitzMatrix(matrix));

  }
}
