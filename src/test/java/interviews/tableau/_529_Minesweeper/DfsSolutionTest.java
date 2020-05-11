package interviews.tableau._529_Minesweeper;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/23/2020
 */
class DfsSolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final char[][] input = {
        {'E', 'E', 'E', 'E', 'E'},
        {'E', 'E', 'M', 'E', 'E'},
        {'E', 'E', 'E', 'E', 'E'},
        {'E', 'E', 'E', 'E', 'E'}};
    final int[] click = new int[]{3, 0};
    final char[][] expected = {
        {'B', '1', 'E', '1', 'B'},
        {'B', '1', 'M', '1', 'B'},
        {'B', '1', '1', '1', 'B'},
        {'B', 'B', 'B', 'B', 'B'}};

    final char[][] actual = solution.updateBoard(input, click);
//    TwoDimensionArray.toString(actual);
    assertTrue(Arrays.deepEquals(expected, actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final char[][] input = {
        {'B', '1', 'E', '1', 'B'},
        {'B', '1', 'M', '1', 'B'},
        {'B', '1', '1', '1', 'B'},
        {'B', 'B', 'B', 'B', 'B'}
    };
    final int[] click = new int[]{1, 2};
    final char[][] expected = {
        {'B', '1', 'E', '1', 'B'},
        {'B', '1', 'X', '1', 'B'},
        {'B', '1', '1', '1', 'B'},
        {'B', 'B', 'B', 'B', 'B'}
    };

    assertTrue(Arrays.deepEquals(expected, solution.updateBoard(input, click)));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new DfsSolution()
    );
  }
}