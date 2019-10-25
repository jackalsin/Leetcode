package interviews.oracle._050_Pow_x_n;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/24/2019
 */
class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithBasePositiveIndexPositive(Solution solution) {
    assertEquals(Math.pow(3, 5), solution.myPow(3, 5), 1e-8);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithBasePositiveIndexNegative(Solution solution) {
    assertEquals(Math.pow(3, -5), solution.myPow(3, -5), 1e-8);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithBaseNegativeIndexNegative(Solution solution) {
    assertEquals(Math.pow(-3, -5), solution.myPow(-3, -5), 1e-8);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithBaseNegativeIndexPositive(Solution solution) {
    assertEquals(Math.pow(-3, 5), solution.myPow(-3, 5), 1e-8);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithBaseSmallIndexLarge(Solution solution) {
    double base = 0.00001;
    int index = 2147483647;
    assertEquals(Math.pow(base, index), solution.myPow(base, index), 1e-8);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}