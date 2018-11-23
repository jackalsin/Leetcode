package _0451_0500._474_Ones_and_Zeroes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/27/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  /**
   * Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3 Output: 4
   */
  @Test
  public void testOnlineCase1() throws Exception {
    final String[] input = {"10", "0001", "111001", "1", "0"};
    assertEquals(4, solution.findMaxForm(input, 5, 3));
  }

  /**
   * Input: Array = {"10", "0", "1"}, m = 1, n = 1 Output: 2
   */
  @Test
  public void testOnlineCase2() throws Exception {
    final String[] input = {"10", "1", "0"};
    assertEquals(2, solution.findMaxForm(input, 1, 1));
  }

}
