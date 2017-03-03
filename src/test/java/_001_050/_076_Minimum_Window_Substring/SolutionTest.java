package _001_050._076_Minimum_Window_Substring;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2017/1/27.
 */
public class SolutionTest {
  private Solution solution ;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithOnlineCase() throws Exception {
    assertEquals("BANC", solution.minWindow("ADOBECODEBANC", "ABC"));
  }

}