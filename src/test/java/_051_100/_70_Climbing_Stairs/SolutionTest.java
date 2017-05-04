package _051_100._70_Climbing_Stairs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 4/28/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWith1() throws Exception {
    assertEquals(1, solution.climbStairs(1));
  }

  @Test
  public void testWith2() throws Exception {
    assertEquals(2, solution.climbStairs(2));
  }
  @Test
  public void testWith3() throws Exception {
    assertEquals(3, solution.climbStairs(3));
  }

  @Test
  public void testWith4() throws Exception {
    assertEquals(5, solution.climbStairs(4));
  }
}
