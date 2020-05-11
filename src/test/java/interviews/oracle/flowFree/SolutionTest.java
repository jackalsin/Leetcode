package interviews.oracle.flowFree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 12/5/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    // R, 0, 0, 0
    // B, 0, Y, 0
    // 0, Y, B, 0
    // 0, 0, 0, R
    final int[][][] input = {
        {{0, 0}, {3, 3}},
        {{1, 0}, {2, 2}},
        {{1, 2}, {2, 1}},
    };

    final int[][] expected = {
        {0, 0, 0, 0},
        {1, 2, 2, 0},
        {1, 2, 1, 0},
        {1, 1, 1, 0},
    }, actual = solution.solve(4, input);
    assertTrue(Arrays.deepEquals(expected, actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}