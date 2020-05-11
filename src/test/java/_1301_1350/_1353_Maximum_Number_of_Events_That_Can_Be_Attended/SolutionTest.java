package _1301_1350._1353_Maximum_Number_of_Events_That_Can_Be_Attended;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/15/2020
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase0(Solution solution) {
    final int[][] input = {{1, 2}, {2, 3}, {3, 4}};
    assertEquals(3, solution.maxEvents(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] input = {{1, 2}, {2, 3}, {3, 4}, {1, 2}};
    assertEquals(4, solution.maxEvents(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[][] input = {{1, 4}, {4, 4}, {2, 2}, {3, 4}, {1, 1}};
    assertEquals(4, solution.maxEvents(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[][] input = {{1, 10000}};
    assertEquals(1, solution.maxEvents(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int[][] input = {{1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}, {1, 7}};
    assertEquals(7, solution.maxEvents(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final int[][] input = {{1, 5}, {1, 5}, {1, 5}, {2, 3}, {2, 3}};
    assertEquals(5, solution.maxEvents(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}