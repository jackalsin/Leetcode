package _301_350._338_Counting_Bits;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 10/5/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int[] expected = {0, 1, 1, 2, 1, 2};
    assertArrayEquals(expected, solution.countBits(5));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] expected = {0, 1, 1, 2, 1};
    assertArrayEquals(expected, solution.countBits(4));
  }

}
