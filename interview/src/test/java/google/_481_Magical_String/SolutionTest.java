package google._481_Magical_String;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/21/2018.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    assertEquals(3, solution.magicalString(6));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    assertEquals(5, solution.magicalString(12));
  }

  @Test
  public void testFailedOnCountOfOne() throws Exception {
    assertEquals(2, solution.magicalString(4));
  }
}
