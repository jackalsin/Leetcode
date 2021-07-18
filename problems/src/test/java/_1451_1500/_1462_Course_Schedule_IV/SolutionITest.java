package _1451_1500._1462_Course_Schedule_IV;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int numCourses = 2;
    final int[][] prerequisites = {
        {1, 0}
    }, queries = {{0, 1}, {1, 0}};
    final List<Boolean> expected = List.of(
        false, true
    ), actual = solution.checkIfPrerequisite(numCourses, prerequisites, queries);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int numCourses = 2;
    final int[][] prerequisites = {}, queries = {{0, 1}, {0, 1}};
    final List<Boolean> expected = List.of(
        false, false
    ), actual = solution.checkIfPrerequisite(numCourses, prerequisites, queries);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int numCourses = 3;
    final int[][] prerequisites = {
        {1, 2},
        {1, 0},
        {2, 0}
    }, queries = {{1, 0}, {1, 2}};
    final List<Boolean> expected = List.of(
        true, true
    ), actual = solution.checkIfPrerequisite(numCourses, prerequisites, queries);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new DfsSolution(),
        new BellFordSolution()
    );
  }
}
