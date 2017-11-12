package _401_450._402_Remove_K_Digits;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 11/12/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnline1432219() throws Exception {
    assertEquals("1219", solution.removeKdigits("1432219", 3));
  }

  /**
   * Leading Zero will be tested.
   *
   * @throws Exception
   */
  @Test
  public void testOnline10200() throws Exception {
    assertEquals("200", solution.removeKdigits("10200", 1));
  }

  @Test
  public void testOnline10() throws Exception {
    assertEquals("0", solution.removeKdigits("10", 2));
//    assertEquals("0", solution.sampleSolution("9", 1));
  }

  @Test
  public void testFailedOn9() throws Exception {
    assertEquals("0", solution.removeKdigits("9", 1));
  }

  @Test
  public void testFailedOn112() throws Exception {
    assertEquals("11",solution.removeKdigits("112", 1));
  }
}
