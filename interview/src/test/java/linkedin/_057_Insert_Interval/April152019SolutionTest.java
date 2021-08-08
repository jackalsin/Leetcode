package linkedin._057_Insert_Interval;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 7/9/2019
 */
class April152019SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase1(April152019Solution solution) {
    final int[] newInterval = {5, 7};
    final int[][] expected = {newInterval};
    assertArrayEquals(expected, solution.insert(new int[][]{}, newInterval));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase2(April152019Solution solution) {
    final int[] newInterval = {2, 5};
    final int[][] expected = {{1, 5}, {6, 9}},
        actual = solution.insert(
            new int[][]{{1, 3}, {6, 9}},
            newInterval);
    assertArrayEquals(expected, actual);
  }

  static Stream<April152019Solution> solutionStream() {
    return Stream.of(
        new SolutionIV(),
        new SolutionV(),
        new SolutionVI()
    );
  }
}
