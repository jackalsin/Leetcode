package _0851_0900._857_Minimum_Cost_to_Hire_K_Workers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/10/2020
 */
class SolutionITest {

  private static final double BIAS = 1E-5;

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int quality[] = {10, 20, 5}, wage[] = {70, 50, 30}, K = 2;
    final double expected = 105.00000, actual = solution.mincostToHireWorkers(quality, wage, K);
    assertEquals(expected, actual, BIAS);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int quality[] = {3, 1, 10, 10, 1}, wage[] = {4, 8, 2, 2, 7}, K = 3;
    final double expected = 30.66667, actual = solution.mincostToHireWorkers(quality, wage, K);
    assertEquals(expected, actual, BIAS);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}