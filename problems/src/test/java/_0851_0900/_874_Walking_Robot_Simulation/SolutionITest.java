package _0851_0900._874_Walking_Robot_Simulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/13/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int commands[] = {4, -1, 3}, obstacles[][] = {}, expected = 25, actual = solution.robotSim(commands,
        obstacles);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int commands[] = {4, -1, 4, -2, 4}, obstacles[][] = {{2, 4}}, expected = 65, actual =
        solution.robotSim(commands, obstacles);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}