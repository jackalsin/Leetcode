package _151_200._198_House_Robber;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/4/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEmpty() throws Exception {
    final int[] input = new int[] {};
    assertEquals(0, solution.rob(input));
  }

  @Test
  public void testOne() throws Exception {
    final int[] input = new int[] {1};
    assertEquals(1, solution.rob(input));
  }

  @Test
  public void testTwo() throws Exception {
    final int[] input = new int[] {1, 2};
    assertEquals(2, solution.rob(input));
  }


  @Test
  public void testThree() throws Exception {
    final int[] input = new int[] {1, 2, 3};
    assertEquals(4, solution.rob(input));
  }

  @Test
  public void test131() throws Exception {
    final int[] input = new int[] {1, 3, 1};
    assertEquals(3, solution.rob(input));
  }
}
