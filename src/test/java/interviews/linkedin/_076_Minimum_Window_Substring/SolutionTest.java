package interviews.linkedin._076_Minimum_Window_Substring;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/19/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new SolutionII();
//    solution = new SolutionI();
  }

  @Test
  public void testA() throws Exception {
    final String s = "a";
    final String t = "a";
    assertEquals(s, solution.minWindow(s, t));
  }

  @Test
  public void testADOBECODEBANC() throws Exception {
    final String s = "ADOBECODEBANC";
    final String t = "ABC";
    assertEquals("BANC", solution.minWindow(s, t));
  }
}
