package apple._305_Number_of_Islands_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/28/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    final int[][] input = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};
    final List<Integer> actual = solution.numIslands2(3, 3, input),
        expected = List.of(1, 1, 2, 3);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase(Solution solution) {
    final int[][] input = {{0, 1}, {1, 2}, {2, 1}, {1, 0}, {0, 2},
        {0, 0}, {1, 1}};
    final List<Integer> actual = solution.numIslands2(3, 3, input),
        expected = List.of(1, 2, 3, 4, 3, 2, 1);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase1(Solution solution) {
    final int[][] input = {{0, 0}, {0, 1}, {1, 2}, {1, 2}};
    final List<Integer> actual = solution.numIslands2(3, 3, input),
        expected = List.of(1, 1, 2, 2);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase2(Solution solution) {
    final int[][] input = {{7, 0}};
    final List<Integer> actual = solution.numIslands2(8, 2, input),
        expected = List.of(1);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}