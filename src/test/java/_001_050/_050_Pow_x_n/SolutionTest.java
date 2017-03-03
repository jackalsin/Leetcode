package _001_050._050_Pow_x_n;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/2/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithBasePositiveIndexPositive() throws Exception {
    assertEquals(Math.pow(3, 5), solution.myPow(3, 5), 1e-8);
  }

  @Test
  public void testWithBasePositiveIndexNegative() throws Exception {
    assertEquals(Math.pow(3, -5), solution.myPow(3, -5), 1e-8);
  }

  @Test
  public void testWithBaseNegativeIndexNegative() throws Exception {
    assertEquals(Math.pow(-3, -5), solution.myPow(-3, -5), 1e-8);
  }

  @Test
  public void testWithBaseNegativeIndexPositive() throws Exception {
    assertEquals(Math.pow(-3, 5), solution.myPow(-3, 5), 1e-8);
  }

  @Test
  public void testWithBaseSmallIndexLarge() throws Exception {
    double base = 0.00001;
    int index = 2147483647;
    assertEquals(Math.pow(base, index), solution.myPow(base, index), 1e-8);
  }
}