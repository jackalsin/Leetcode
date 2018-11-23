package _0301_0350._312_Burst_Balloons;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/18/2017.
 */
public class SolutionTest {

  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void onlineCase() throws Exception {
    final int[] input = {3, 1, 5, 8};
    assertEquals(167, solution.maxCoins(input));
  }
}
