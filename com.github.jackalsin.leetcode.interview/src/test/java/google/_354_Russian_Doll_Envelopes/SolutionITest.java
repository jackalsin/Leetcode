package google._354_Russian_Doll_Envelopes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/20/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase(Solution solution) {
    final int[][] input = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
    assertEquals(3, solution.maxEnvelopes(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testEmpty(Solution solution) {
    final int[][] input = {};
    assertEquals(0, solution.maxEnvelopes(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase2(Solution solution) {
    final int[][] input = {{5, 4}, {6, 5}, {6, 7}, {2, 3}, {7, 6}};
    assertEquals(4, solution.maxEnvelopes(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase3(Solution solution) {
    final int[][] input = {{1, 1}, {1, 1}, {1, 1}};
    assertEquals(1, solution.maxEnvelopes(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase4(Solution solution) {
    final int[][] input = {{4, 5}, {4, 6}, {6, 7}, {2, 3}, {1, 1}, {1, 1}};
    assertEquals(4, solution.maxEnvelopes(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase5(Solution solution) {
    final int[][] input = {{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}};
    // [2, 100] -> [3, 200] -> [4, 300] -> [5, 400]
    // [2, 100] -> [3, 200] -> [5, 250] -> [6, 360] -> [7, 380]
    assertEquals(5, solution.maxEnvelopes(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase6(Solution solution) {
    final int[][] input = {{46, 89}, {50, 53}, {52, 68}, {72, 45}, {77, 81}};
    assertEquals(3, solution.maxEnvelopes(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}