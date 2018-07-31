package _001_050._050_Pow_x_n;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/2/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testWithBasePositiveIndexPositive() {
    assertEquals(Math.pow(3, 5), solution.myPow(3, 5), 1e-8);
  }

  @Test
  void testWithBasePositiveIndexNegative() {
    assertEquals(Math.pow(3, -5), solution.myPow(3, -5), 1e-8);
  }

  @Test
  void testWithBaseNegativeIndexNegative() {
    assertEquals(Math.pow(-3, -5), solution.myPow(-3, -5), 1e-8);
  }

  @Test
  void testWithBaseNegativeIndexPositive() {
    assertEquals(Math.pow(-3, 5), solution.myPow(-3, 5), 1e-8);
  }

  @Test
  void testWithBaseSmallIndexLarge() {
    double base = 0.00001;
    int index = 2147483647;
    assertEquals(Math.pow(base, index), solution.myPow(base, index), 1e-8);
  }
}