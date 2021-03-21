package _1501_1550._1514_Path_with_Maximum_Probability;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/20/2021
 */
class SolutionITest {
  private static final double BIAS = 1E-5;

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int n = 3, edges[][] = {{0, 1}, {1, 2}, {0, 2}},
        start = 0, end = 2;
    final double succProb[] = {0.5, 0.5, 0.2};
    assertEquals(0.2500, solution.maxProbability(n, edges, succProb, start, end), BIAS);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int n = 3, edges[][] = {{0, 1}, {1, 2}, {0, 2}},
        start = 0, end = 2;
    final double succProb[] = {0.5, 0.5, 0.3};
    assertEquals(0.3000, solution.maxProbability(n, edges, succProb, start, end), BIAS);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int n = 3, edges[][] = {{0, 1}},
        start = 0, end = 2;
    final double succProb[] = {0.5};
    assertEquals(0.0, solution.maxProbability(n, edges, succProb, start, end), BIAS);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int n = 5, edges[][] = {
        {2, 3}, {1, 2}, {3, 4}, {1, 3}, {1, 4}, {0, 1}, {2, 4}, {0, 4}, {0, 2}
    }, start = 0, end = 3;
    final double succProb[] = {0.06, 0.26, 0.49, 0.25, 0.2, 0.64, 0.23, 0.21, 0.77};
    assertEquals(0.16000, solution.maxProbability(n, edges, succProb, start, end), BIAS);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}