package _151_200._179_Largest_Number;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 8/2/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int[] input = new int[] {3, 30, 34, 5, 9};
    assertEquals("9534330", solution.largestNumber(input));
  }

  @Test
  public void testEmpty() throws Exception {
    assertEquals("0", solution.largestNumber(new int[]{}));
  }

  @Test
  public void testDuplicated0Element() throws Exception {
    assertEquals("0", solution.largestNumber(new int[]{0, 0}));
  }
}
