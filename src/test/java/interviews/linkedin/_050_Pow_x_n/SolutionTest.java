package interviews.linkedin._050_Pow_x_n;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/17/2017.
 */
public class SolutionTest {
  private static final double DELTA = 1E-9;
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new SimpleSolution();
  }

  @Test
  public void testNormalCase1() throws Exception {
    final double x = 2d;
    final int n = 5;
    assertEquals(Math.pow(x, n), solution.myPow(x, n), DELTA);
  }

  @Test
  public void testFailedCase1() throws Exception {
    final double x = 0.44528;
    final int n = 0;
    assertEquals(1d, solution.myPow(x, n), DELTA);
  }

  @Test
  public void testFailedCase2() throws Exception {
    final double x = 34.00515;
    final int n = -3;
    assertEquals(Math.pow(x, n), solution.myPow(x, n), DELTA);
  }

  @Test
  public void testFailedCase3() throws Exception {
    final double x = 0.00001;
    final int n = 2147483647;
    assertEquals(Math.pow(x, n), solution.myPow(x, n), DELTA);
  }

  @Test
  public void testFailedCase4() throws Exception {
    final double x = 2d;
    final int n = Integer.MIN_VALUE;
    assertEquals(Math.pow(x, n), solution.myPow(x, n), DELTA);
  }
}
