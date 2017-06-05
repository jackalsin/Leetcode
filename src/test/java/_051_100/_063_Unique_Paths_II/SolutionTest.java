package _051_100._063_Unique_Paths_II;

import org.junit.Before;
import org.junit.Test;

import javax.swing.text.EditorKit;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 4/24/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void uniquePathsWithObstacles() throws Exception {
    int[][] input = new int[][]{{0, 0, 0}, {0, 1, 0}, {0,0,0}};
    assertEquals(2, solution.uniquePathsWithObstacles(input));
  }

  @Test
  public void testWith1by1() throws Exception {
    assertEquals(1, solution.uniquePathsWithObstacles(new int[][]{{0}}));
  }
}
