package linkedin._050_Pow_x_n;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/17/2017.
 */
class SolutionTest {
  private static final double DELTA = 1E-6;

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testNormalCase1(Solution solution) {
    final double x = 2d;
    final int n = 5;
    assertEquals(Math.pow(x, n), solution.myPow(x, n), DELTA);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase1(Solution solution) {
    final double x = 0.44528;
    final int n = 0;
    assertEquals(1d, solution.myPow(x, n), DELTA);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase2(Solution solution) {
    final double x = 34.00515;
    final int n = -3;
    final double actual = solution.myPow(x, n);
    final double expected = Math.pow(x, n);
    assertEquals(expected, actual, DELTA);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase3(Solution solution) {
    final double x = 0.00001;
    final int n = 2147483647;
    assertEquals(Math.pow(x, n), solution.myPow(x, n), DELTA);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase4(Solution solution) {
    final double x = 2d;
    final int n = Integer.MIN_VALUE;
    assertEquals(Math.pow(x, n), solution.myPow(x, n), DELTA);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new MemoSolution(),
        new SimpleSolution(),
        new SolutionV()
    );
  }
}
