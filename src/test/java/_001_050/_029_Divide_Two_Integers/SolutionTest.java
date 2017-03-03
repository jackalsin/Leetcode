package _001_050._029_Divide_Two_Integers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/24/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithMinimumDividesOne() throws Exception {
    assertEquals(Integer.MIN_VALUE, solution.divide(Integer.MIN_VALUE, 1));
  }

  @Test
  public void testWithMinimumDivideNegativeOne() throws Exception {
    assertEquals(Integer.MAX_VALUE, solution.divide(Integer.MIN_VALUE, -1));
  }

  @Test
  public void testWithDividendZero() throws Exception {
    assertEquals(0, solution.divide(0, 1));
  }

  @Test
  public void testWithDivisorMinValue() throws Exception {
    assertEquals(0, solution.divide(1, Integer.MIN_VALUE));
  }

  @Test
  public void testWith32By3() throws Exception {
    assertEquals(32 / 3, solution.divide(32, 3));
  }

  @Test
  public void testWith32byN3() throws Exception {
    assertEquals(-32 / 3, solution.divide(-32, 3));
  }
  @Test
  public void testWith1By1() throws Exception {
    assertEquals(1/1, solution.divide(1, 1));
  }

  @Test
  public void testWith2147483647By1() throws Exception {
    assertEquals(2147483647, solution.divide(2147483647, 1));
  }
  @Test
  public void testWithIntMinBy2() throws Exception {
    assertEquals(Integer.MIN_VALUE / 2, solution.divide(Integer.MIN_VALUE , 2));
  }
}
