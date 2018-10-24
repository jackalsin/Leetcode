package _051_100._074_Search_a_2D_Matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 5/11/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testWith1By1() throws Exception {
    assertTrue(solution.searchMatrix(new int[][]{{1}}, 1));
  }

  @Test
  void testWith1By1False() throws Exception {
    assertFalse(solution.searchMatrix(new int[][]{{1}}, 0));
  }

  @Test
  void testWith3By3True() throws Exception {
    final int[][] input = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    for (int i = 1; i < 10; i++) {
      assertTrue(solution.searchMatrix(input, i));
    }

    assertFalse(solution.searchMatrix(input, 0));
    assertFalse(solution.searchMatrix(input, 10));
  }
}