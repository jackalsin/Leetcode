package interviews.google.gas_station;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/24/2018.
 */
public class SolutionTest {
  private Solution solution;
  private static final double BIAS = 1E-9;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] gasStation = {0, 1, 4, 9, 18};
    final double actual = solution.minimizeGasStation(gasStation, 2);
    assertEquals(4.5, actual, BIAS);
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] gasStation = {0, 1, 4, 9, 18};
    final double actual = solution.minimizeGasStation(gasStation, 1);
    assertEquals(5, actual, BIAS);
  }
}
