package _0151_0200._153_Find_Minimum_in_Rotated_Sorted_Array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/16/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOneElement() throws Exception {
    final int[] input = new int[] {1};
    assertEquals(1, solution.findMin(input));
  }

  @Test
  public void testTwoElement() throws Exception {
    final int[] input = new int[] {1, 2};
    assertEquals(1, solution.findMin(input));
  }

  @Test
  public void testTwoElements() throws Exception {
    final int[] input = new int[] {2, 1};
    assertEquals(1, solution.findMin(input));
  }

  @Test
  public void test5Elements() throws Exception {
    final int[] input = new int[] {2, 3, 4, 0,  1};
    assertEquals(0, solution.findMin(input));
  }

}