package facebook._621_Task_Scheduler;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/21/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final char[] chars = {'A', 'A', 'A', 'B', 'B', 'B'};
    assertEquals(8, solution.leastInterval(chars, 2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final char[] chars = {'A', 'A', 'A', 'B', 'B', 'B'};
    assertEquals(6, solution.leastInterval(chars, 0));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final char[] chars = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
    assertEquals(16, solution.leastInterval(chars, 2));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new BruteForceSolution(),
        new MathSolution()
    );
  }
}