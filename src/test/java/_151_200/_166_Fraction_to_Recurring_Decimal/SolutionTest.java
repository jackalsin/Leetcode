package _151_200._166_Fraction_to_Recurring_Decimal;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 7/29/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testZero() throws Exception {
    assertEquals("0", solution.fractionToDecimal(0, 1));
    assertEquals("0", solution.fractionToDecimal(0, -1));
  }

  @Test
  public void testOverflowNumPositive() throws Exception {
    assertEquals(String.valueOf(Integer.MAX_VALUE),
        solution.fractionToDecimal(Integer.MAX_VALUE, 1));
  }

  @Test
  public void testDecimal() throws Exception {
    assertEquals("1.(6)", solution.fractionToDecimal(10, 6));
  }

  @Test
  public void testDecimalNeg() throws Exception {
    assertEquals("-1.(6)", solution.fractionToDecimal(-10, 6));
  }

  @Test
  public void test1And333() throws Exception {
    assertEquals("0.(003)", solution.fractionToDecimal(1, 333));
  }
}
