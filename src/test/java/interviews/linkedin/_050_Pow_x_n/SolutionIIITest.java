package interviews.linkedin._050_Pow_x_n;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/17/2017.
 */
class SolutionIIITest {
  private static final double DELTA = 1E-9;
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new SolutionIII();
  }

  @Test
  void testNormalCase1() throws Exception {
    final double x = 2d;
    final int n = 5;
    assertEquals(Math.pow(x, n), solution.myPow(x, n), DELTA);
  }

  @Test
  void testFailedCase1() throws Exception {
    final double x = 0.44528;
    final int n = 0;
    assertEquals(1d, solution.myPow(x, n), DELTA);
  }

  @Test
  void testFailedCase2() throws Exception {
    final double x = 34.00515;
    final int n = -3;
    final double actual = solution.myPow(x, n);
    final double expected = Math.pow(x, n);
    assertEquals(expected, actual, DELTA);
  }

  @Test
  void testFailedCase3() throws Exception {
    final double x = 0.00001;
    final int n = 2147483647;
    assertEquals(Math.pow(x, n), solution.myPow(x, n), DELTA);
  }

  @Test
  void testFailedCase4() throws Exception {
    final double x = 2d;
    final int n = Integer.MIN_VALUE;
    assertEquals(Math.pow(x, n), solution.myPow(x, n), DELTA);
  }
}
