package _201_250._233_Number_of_Digit_One;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 7/23/2017.
 */
public class SolutionTest {

  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test0() throws Exception {
    assertEquals(0, solution.countDigitOne(0));
  }

  @Test
  public void test1() throws Exception {
    assertEquals(1, solution.countDigitOne(1));
  }

  @Test
  public void test13() throws Exception {
    assertEquals(6, solution.countDigitOne(13));
  }

  @Test
  public void testNegative1() throws Exception {
    assertEquals(0, solution.countDigitOne(-1));
  }

  @Test
  public void test23() throws Exception {
    assertEquals(13, solution.countDigitOne(23));
  }

  @Test
  public void test20() throws Exception {
    assertEquals(12, solution.countDigitOne(20));
  }

  @Test
  public void test12316() throws Exception {
    assertEquals(8086, solution.countDigitOne(12316));
  }
}
