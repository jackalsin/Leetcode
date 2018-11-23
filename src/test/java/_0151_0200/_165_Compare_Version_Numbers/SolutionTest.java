package _0151_0200._165_Compare_Version_Numbers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/27/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEqualNormal() throws Exception {
    assertEquals(0, solution.compareVersion("0", "0"));
  }

  @Test
  public void testEqualDigitsDiff() throws Exception {
    assertEquals(0, solution.compareVersion("0.0.0", "0"));
  }

  @Test
  public void testGreaterWithTheSameDigits() throws Exception {
    assertEquals(1, solution.compareVersion("1.11.2", "1.11.1"));
  }

  @Test
  public void testGreaterWithDiffDigit() throws Exception {
    assertEquals(1, solution.compareVersion("1.11.2", "1.11"));
  }
  @Test
  public void testGreaterWithDiffDigits() throws Exception {
    assertEquals(1, solution.compareVersion("1.11.2", "1"));
  }

}
