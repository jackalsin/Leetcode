package byteDance._207_Course_Schedule;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 3/21/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testPossible(Solution solution) {
    assertTrue(solution.canFinish(2, new int[][]{{1, 0}}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testImpossible(Solution solution) {
    assertFalse(solution.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}