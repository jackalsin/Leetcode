package _0501_0550._514_Freedom_Trail;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String ring = "godding", key = "gd";
    assertEquals(4, solution.findRotateSteps(ring, key));
  }

  @Test
  public void testTLECase1() {
    final String ring = "caotmcaataijjxi", key = "oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx";
    solution.findRotateSteps(ring, key);
  }
}