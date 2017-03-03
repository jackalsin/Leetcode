package _001_050._042_Trapping_Rain_Water;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/20/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithOnlineCase() throws Exception {
    assertEquals(6, solution.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
  }

}