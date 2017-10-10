package _351_400._354_Russian_Doll_Envelopes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 10/9/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int[][] input = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
    assertEquals(3, solution.maxEnvelopes(input));
  }

  @Test
  public void testEmpty() throws Exception {
    final int[][] input = {};
    assertEquals(0, solution.maxEnvelopes(input));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[][] input = {{5, 4}, {6, 5}, {6, 7}, {2, 3}, {7, 6}};
    assertEquals(4, solution.maxEnvelopes(input));
  }

}
