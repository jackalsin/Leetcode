package interviews.facebook._050_Pow_x_n;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConstantSpaceSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new ConstantSpaceSolution();
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

  @Test
  void testWithBaseSmallIndexMinValue() {
    double base = 0.00001;
    int index = Integer.MIN_VALUE;
    assertEquals(Math.pow(base, index), solution.myPow(base, index), 1e-8);
  }
}