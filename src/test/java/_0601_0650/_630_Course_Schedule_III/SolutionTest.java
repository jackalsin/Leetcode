package _0601_0650._630_Course_Schedule_III;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[][] input = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
    assertEquals(3, solution.scheduleCourse(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase(Solution solution) {
    final int[][] input = {{1, 2}, {2, 3}};
    assertEquals(2, solution.scheduleCourse(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase2(Solution solution) {
    final int[][] input = {{5, 5}, {4, 6}, {2, 6}};
    assertEquals(2, solution.scheduleCourse(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase3(Solution solution) {
    final int[][] input = {{5, 15}, {3, 19}, {6, 7}, {2, 10}, {5, 16}, {8, 14}, {10, 11}, {2, 19}};
    assertEquals(5, solution.scheduleCourse(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}