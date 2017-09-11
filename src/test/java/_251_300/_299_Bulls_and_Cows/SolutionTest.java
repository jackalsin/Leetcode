package _251_300._299_Bulls_and_Cows;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 9/10/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    assertEquals("1A3B", solution.getHint("1807", "7810"));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    assertEquals("1A1B", solution.getHint("1123", "0111"));
  }

  @Test
  public void testOnlineCase3() throws Exception {
    assertEquals("0A4B", solution.getHint("1122", "2211"));
  }

}
