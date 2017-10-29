package _351_400._365_Water_and_Jug_Problem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/26/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    assertTrue(solution.canMeasureWater(3, 5, 4));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    assertFalse(solution.canMeasureWater(2, 6, 5));
  }

  @Test
  public void testFailedCase1() throws Exception {
    assertTrue(solution.canMeasureWater(0, 0, 0));
  }

  @Test
  public void testFailedOnGcd() throws Exception {
    assertTrue(solution.canMeasureWater(1, 2, 3));
  }
}
