package _201_250._227_Basic_Calculator_II;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 8/17/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnline1() throws Exception {
    final String input = "3+2*2";
    assertEquals(7, solution.calculate(input));
  }

  @Test
  public void testOnline2() throws Exception {
    final String input = " 3/2 ";
    assertEquals(1, solution.calculate(input));
  }

  @Test
  public void testOnline3() throws Exception {
    final String input = " 3+5 / 2 ";
    assertEquals(5, solution.calculate(input));
  }
}
