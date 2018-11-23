package _0251_0300._287_Find_the_Duplicate_Number;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/4/2017.
 */
public class SolutionTest {

  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test11() throws Exception {
    final int[] input = new int[]{1, 1};
    assertEquals(1, solution.findDuplicate(input));
  }

  @Test
  public void test112() throws Exception {
    final int[] input = new int[]{1, 1, 2};
    assertEquals(1, solution.findDuplicate(input));
  }

  @Test
  public void test122() throws Exception {
    final int[] input = new int[]{1, 2, 2};
    assertEquals(2, solution.findDuplicate(input));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final int[] input = {1, 3, 4, 2, 1};
    assertEquals(1, solution.findDuplicate(input));
  }

  @Test
  public void testFailedCase2() throws Exception {
    final int[] input = {1, 3, 4, 1, 2};
    assertEquals(1, solution.findDuplicate(input));
  }
}
