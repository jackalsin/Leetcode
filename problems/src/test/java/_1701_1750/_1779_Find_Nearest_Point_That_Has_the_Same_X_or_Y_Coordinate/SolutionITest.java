package _1701_1750._1779_Find_Nearest_Point_That_Has_the_Same_X_or_Y_Coordinate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    //                                        0,      1,      2,      3,      4
    final int x = 3, y = 4, points[][] = {{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}},
        expected = 2, actual = solution.nearestValidPoint(x, y, points);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int x = 3, y = 4, points[][] = {{3, 4}},
        expected = 0, actual = solution.nearestValidPoint(x, y, points);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int x = 3, y = 4, points[][] = {{2, 3}},
        expected = -1, actual = solution.nearestValidPoint(x, y, points);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}
