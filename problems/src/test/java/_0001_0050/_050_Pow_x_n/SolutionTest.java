package _0001_0050._050_Pow_x_n;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/2/2017.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithBasePositiveIndexPositive(Solution solution) {
    assertEquals(Math.pow(3, 5), solution.myPow(3, 5), 1e-8);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithBasePositiveIndexNegative(Solution solution) {
    assertEquals(Math.pow(3, -5), solution.myPow(3, -5), 1e-8);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithBaseNegativeIndexNegative(Solution solution) {
    assertEquals(Math.pow(-3, -5), solution.myPow(-3, -5), 1e-8);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithBaseNegativeIndexPositive(Solution solution) {
    assertEquals(Math.pow(-3, 5), solution.myPow(-3, 5), 1e-8);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithBaseSmallIndexLarge(Solution solution) {
    double base = 0.00001;
    int index = 2147483647;
    assertEquals(Math.pow(base, index), solution.myPow(base, index), 1e-8);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }
}