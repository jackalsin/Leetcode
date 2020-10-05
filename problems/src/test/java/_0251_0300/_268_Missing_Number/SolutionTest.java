package _0251_0300._268_Missing_Number;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/28/2017.
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
    assertEquals(0, solution.missingNumber(input));
  }

  @Test
  public void test1() throws Exception {
    final int[] input = new int[] {0};
    assertEquals(1, solution.missingNumber(input));
  }

  @Test
  public void test2() throws Exception {
    final int[] input = new int[] {0, 1};
    assertEquals(2, solution.missingNumber(input));
  }

}
