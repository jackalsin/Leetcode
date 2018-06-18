package interviews.linkedin._033_Search_in_Rotated_Sorted_Array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/16/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new SolutionII();
  }

  @Test
  public void testFailedCase1() throws Exception {
    final int[] intput = {1, 3, 5};
    assertEquals(-1, solution.search(intput, 0));
  }

  @Test
  public void testFailedCase2() throws Exception {
    final int[] input = {1, 3};
    assertEquals(1, solution.search(input, 3));
  }

  @Test
  public void testFailedCase3() throws Exception {
    final int[] input = {3, 1};
    assertEquals(1, solution.search(input, 1));
  }

  @Test
  public void testFailedOnEmpty() throws Exception {
    final int[] input = {};
    assertEquals(-1, solution.search(input, 3));
  }
}
