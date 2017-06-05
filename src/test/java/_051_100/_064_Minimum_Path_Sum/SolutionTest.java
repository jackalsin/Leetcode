package _051_100._064_Minimum_Path_Sum;

import org.junit.Before;
import org.junit.Test;

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
  public void testWith1By1() throws Exception {
    assertEquals(0, solution.minPathSum(new int[][]{{0}}));
  }

  @Test
  public void testWith3By3() throws Exception {
    assertEquals(9, solution.minPathSum(new int[][]{{1, 2, 3}, {2, 4, 1}, {3, 1, 2}}));
  }

  @Test
  public void testWith3by1() throws Exception {
    assertEquals(4, solution.minPathSum(new int[][]{{0, 1, 3}}));
  }
}
