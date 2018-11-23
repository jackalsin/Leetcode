package _0201_0250._248_Strobogrammatic_Number_III;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/24/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testZero() throws Exception {
    assertEquals(1, solution.strobogrammaticInRange("0", "0"));
  }

  @Test
  public void testLeadingZero() throws Exception {
    assertEquals(3, solution.strobogrammaticInRange("90", "111"));
  }
}
