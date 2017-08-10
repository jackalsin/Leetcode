package _201_250._213_House_Robber_II;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 8/9/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEmpty() throws Exception {
    assertEquals(0, solution.rob(new int[]{}));
  }

  @Test
  public void testOne() throws Exception {
    assertEquals(1, solution.rob(new int[]{1}));
  }

  @Test
  public void testTwo() throws Exception {
    final int[] input = new int[] {1, 2};
    assertEquals(2, solution.rob(input));
  }


  @Test
  public void testThree() throws Exception {
    final int[] input = new int[] {1, 2, 3};
    assertEquals(3, solution.rob(input));
  }

  @Test
  public void test131() throws Exception {
    final int[] input = new int[] {1, 3, 1};
    assertEquals(3, solution.rob(input));
  }

  @Test
  public void testMaxHead() throws Exception {
    final int[] input = new int[] {6, 1, 5};
    assertEquals(6, solution.rob(input));
  }

  @Test
  public void testMaxTail() throws Exception {
    final int[] input = new int[] {6, 1, 11};
    assertEquals(11, solution.rob(input));
  }

  @Test
  public void testFailed1() throws Exception {
    final int[] input = new int[] {1,2,1,0};
    assertEquals(2, solution.rob(input));
  }
}
