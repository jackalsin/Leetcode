package _0551_0600._568_Maximum_Vacation_Days;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[][] flights = {
        {0, 1, 1},
        {1, 0, 1},
        {1, 1, 0}
    }, days = {
        {1, 3, 1},
        {6, 0, 3},
        {3, 3, 3}};
    assertEquals(12, solution.maxVacationDays(flights, days));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[][] flights = {
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0}
    }, days = {
        {1, 1, 1},
        {7, 7, 7},
        {7, 7, 7}
    };
    assertEquals(3, solution.maxVacationDays(flights, days));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int[][] flights = {{0, 1, 1}, {1, 0, 1}, {1, 1, 0}}, days = {{7, 0, 0}, {0, 7, 0}, {0, 0, 7}};
    assertEquals(21, solution.maxVacationDays(flights, days));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase1(Solution solution) {
    final int[][] flights = {
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {1, 1, 0, 1, 0},
        {1, 0, 0, 0, 0},
        {1, 1, 1, 1, 0}
    }, days = {
        {0, 1, 1, 0, 0},
        {1, 2, 2, 1, 2},
        {2, 0, 0, 2, 1},
        {0, 2, 1, 2, 2},
        {0, 1, 1, 1, 0}
    };
    assertEquals(2, solution.maxVacationDays(flights, days));
  }
}
