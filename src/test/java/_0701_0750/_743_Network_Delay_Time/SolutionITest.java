package _0701_0750._743_Network_Delay_Time;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/31/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int times[][] = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, N = 4, K = 2, expected = 2;
    assertEquals(expected, solution.networkDelayTime(times, N, K));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int times[][] = {{1, 2, 1}, {2, 3, 2}, {1, 3, 4}}, N = 3, K = 1, expected = 3;
    assertEquals(expected, solution.networkDelayTime(times, N, K));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}