package doordash._207_Course_Schedule;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test4(Solution solution) {
    final int numnberCourses = 4, prerequisites[][] = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
    assertTrue(solution.canFinish(numnberCourses, prerequisites));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new DfsSolutionHasCycle(),
        new VisitSolution(),
        new SolutionII()
    );
  }

}