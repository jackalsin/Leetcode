package lime._056_Merge_Intervals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 4/9/2021
 */
class SolutionITest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithOnlineCase1(Solution solution) {
    final int[][] input = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15,
        18}};
    final int[][] actual = solution.merge(input),
        expected = {{1, 6}, {8, 10}, {15, 18}};
    assertArrayEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}