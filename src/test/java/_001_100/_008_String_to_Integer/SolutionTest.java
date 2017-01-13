package _001_100._008_String_to_Integer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2017/1/13.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testMaxInteger() throws Exception {
    assertEquals(Integer.MAX_VALUE, solution.myAtoi(String.valueOf(Integer.MAX_VALUE)));
  }

  @Test
  public void testMinInteger() throws Exception {
    assertEquals(Integer.MIN_VALUE, solution.myAtoi(String.valueOf(Integer.MIN_VALUE)));
  }

  @Test
  public void testMinIntegerPlusOne() throws Exception {
    assertEquals(Integer.MIN_VALUE + 1,
        solution.myAtoi(String.valueOf(Integer.MIN_VALUE + 1)));
  }

  @Test
  public void testZero() throws Exception {
    assertEquals(0, solution.myAtoi(String.valueOf("0")));
  }

  @Test
  public void testUpOverflow() throws Exception {
    assertEquals(Integer.MAX_VALUE, solution.myAtoi(String.valueOf("2147483648")));
  }
}
