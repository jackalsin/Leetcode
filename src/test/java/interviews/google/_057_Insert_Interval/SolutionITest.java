package interviews.google._057_Insert_Interval;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 4/14/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithOnlineCase1(Solution solution) {
    final int[][] input = (new int[][]{{1, 3}, {6, 9}});
    final int[][] expected = (new int[][]{{1, 5}, {6, 9}});
    assertArrayEquals(expected, solution.insert(input, new int[]{2, 5}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithOnlineCase2(Solution solution) {
    final int[][] input = (new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}});
    final int[][] expected = (new int[][]{{1, 2}, {3, 10}, {12, 16}});
    assertArrayEquals(expected, solution.insert(input, new int[]{4, 9}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithMissingLastIndex(Solution solution) {
    final int[][] input = (new int[][]{{1, 5}});
    final int[][] expected = (new int[][]{{1, 5}}),
        actual = solution.insert(input, new int[]{2, 3});
    assertArrayEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}