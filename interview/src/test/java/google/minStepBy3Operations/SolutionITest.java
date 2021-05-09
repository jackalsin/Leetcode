package google.minStepBy3Operations;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/8/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    assertEquals(0, solution.minSteps(1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    assertEquals(1, solution.minSteps(2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    assertEquals(1, solution.minSteps(3));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    assertEquals(1, solution.minSteps(4));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase8(Solution solution) {
    assertEquals(2, solution.minSteps(8));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase9(Solution solution) {
    assertEquals(2, solution.minSteps(9));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new DpSolution()
    );
  }
}