package _0801_0850._837_New_21_Game;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/2/2020
 */
class SolutionITest {
  private static final double BIAS = 1E-5;

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int N = 10, K = 1, W = 10;
    assertEquals(1.00000, solution.new21Game(N, K, W), BIAS);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int N = 6, K = 1, W = 10;
    assertEquals(0.60000, solution.new21Game(N, K, W), BIAS);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int N = 21, K = 17, W = 10;
    assertEquals(0.73278, solution.new21Game(N, K, W), BIAS);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int N = 0, K = 0, W = 1;
    assertEquals(1, solution.new21Game(N, K, W), BIAS);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new ONSolution()
//        new MLESolution(),
//        new TLESolution()
    );
  }
}