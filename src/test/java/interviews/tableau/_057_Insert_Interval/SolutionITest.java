package interviews.tableau._057_Insert_Interval;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 2/13/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testWithOnlineCase1(Solution solution) {
    final int[][] input = new int[][]{{1, 3}, {6, 9}},
        expected = new int[][]{{1, 5}, {6, 9}};
    assertArrayEquals(expected, solution.insert(input, new int[]{2, 5}));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testWithOnlineCase2(Solution solution) {
    final int[][] input = (new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}});
    final int[][] expected = (new int[][]{{1, 2}, {3, 10}, {12, 16}});
    assertArrayEquals(expected, solution.insert(input, new int[]{4, 9}));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testWithMissingLastIndex(Solution solution) {
    final int[][] input = new int[][]{{1, 5}},
        expected = new int[][]{{1, 5}};
    assertArrayEquals(expected, solution.insert(input, new int[]{2, 3}));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}