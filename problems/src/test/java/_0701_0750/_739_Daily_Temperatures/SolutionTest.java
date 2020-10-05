package _0701_0750._739_Daily_Temperatures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
    final int[] expected = {1, 1, 4, 2, 1, 1, 0, 0};
    assertArrayEquals(expected, solution.dailyTemperatures(temp));
  }
}
