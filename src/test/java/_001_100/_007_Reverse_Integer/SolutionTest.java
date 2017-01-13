package _001_100._007_Reverse_Integer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2017/1/12.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void reverseZero() throws Exception {
    assertEquals(0, solution.reverse(0));
  }

  @Test
  public void reverseNegativeSingleDigit() throws Exception {
    assertEquals(-1, solution.reverse(-1));
  }

  @Test
  public void reverseNegativeTwoDigits() throws Exception {
    assertEquals(-12, solution.reverse(-21));
  }

  @Test
  public void reversePositiveSingleDigit() throws Exception {
    assertEquals(1, solution.reverse(1));
  }

  @Test
  public void reversePositiveTwoDigits() throws Exception {
    assertEquals(12, solution.reverse(21));
  }

  @Test
  public void reverseMinValue() throws Exception {
    assertEquals(0, solution.reverse(Integer.MIN_VALUE));
  }

  @Test
  public void reverseOverflow() throws Exception {
    assertEquals(-2143847412, solution.reverse(-2147483412));
  }
}