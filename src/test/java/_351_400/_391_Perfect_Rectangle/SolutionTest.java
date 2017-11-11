package _351_400._391_Perfect_Rectangle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 11/10/2017.
 */
public class SolutionTest {

  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testExample1() throws Exception {
    final int[][] rectangles = {
        {1, 1, 3, 3},
        {3, 1, 4, 2},
        {3, 2, 4, 4},
        {1, 3, 2, 4},
        {2, 3, 3, 4}
    };

    assertTrue(solution.isRectangleCover(rectangles));
  }
  @Test
  public void testExample2() throws Exception {
    final int[][] rectangles = {
        {1,1,2,3},
    {1,3,2,4},
      {3,1,4,2},
        {3,2,4,4}
    };
    assertFalse(solution.isRectangleCover(rectangles));
  }
  @Test
  public void testExample3() throws Exception {
    final int[][] rectangles = {
        {1,1,3,3},
    {3,1,4,2},
      {1,3,2,4},
        {3,2,4,4}
    };

    assertFalse(solution.isRectangleCover(rectangles));
  }
  @Test
  public void testExample4() throws Exception {
    final int[][] rectangles = {
        {1,1,3,3},
    {3,1,4,2},
      {1,3,2,4},
        {2,2,4,4}
    };

    assertFalse(solution.isRectangleCover(rectangles));
  }

  /**
   * Failed At validation of point set size should be only 4.
   *
   * @throws Exception
   */
  @Test
  public void testFailedCase1() throws Exception {
    final int[][] rectangles = {{0,0,2,2},{1,1,3,3},{2,0,3,1},{0,3,3,4}};

    assertFalse(solution.isRectangleCover(rectangles));
  }

  /**
   * Check the getPoint, the conversion from int to long will happen, so the negative value will
   * be wrong. THe current way works, but <code>(long) left << 32 | top;</code> is not.
   *
   * @throws Exception
   */
  @Test
  public void testFailedCase2() throws Exception {
    final int N = 2;
    final int[][] rectangles = new int[N][4];
    for (int i = 0; i < N; i++) {
      rectangles[i] = new int[] {0, i - 1, 1, i};
    }
    assertTrue(solution.isRectangleCover(rectangles));
  }

  @Test
  public void testGetPoint() throws Exception {
    System.out.println(Solution.getPoint(1, 1));
  }
}
