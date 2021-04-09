package lime._085_Maximal_Rectangle;

import definition.TwoDimensionArray;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/8/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    final char[][] board = new char[][]{
        {'0', '0', '0', '1', '0', '0', '0'},
        {'0', '0', '1', '1', '1', '0', '0'},
        {'0', '1', '1', '1', '1', '1', '0'}
    };

    assertEquals(6, solution.maximalRectangle(board));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {

    final char[][] board = new char[][]{
        {'0', '0', '0', '1', '0', '0', '0'},
        {'0', '0', '1', '1', '1', '0', '0'},
        {'0', '1', '1', '1', '1', '1', '0'}
    };

    assertEquals(6, solution.maximalRectangle(board));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnline5(Solution solution) {
    final char[][] board = new char[][]{
        {'0', '1', '1', '0', '1'},
        {'1', '1', '0', '1', '0'},
        {'0', '1', '1', '1', '0'},
        {'1', '1', '1', '1', '0'},
        {'1', '1', '1', '1', '1'},
        {'0', '0', '0', '0', '0'}
    };

    assertEquals(9, solution.maximalRectangle(board));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnline3(Solution solution) {
    final String[] input = {
        "11100000",
        "11111111",
        "00001111",
        "00001111"
    };
    char[][] inputBoard = TwoDimensionArray.getCharBoard(input);
    assertEquals(12, solution.maximalRectangle(inputBoard));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnline4(Solution solution) {
    final String[] input = {
        "11100000",
        "11111111",
        "11001111",
        "00001111"
    };
    char[][] inputBoard = TwoDimensionArray.getCharBoard(input);
    assertEquals(12, solution.maximalRectangle(inputBoard));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new DpSolution(),
        new MonoStackSolution()
    );
  }
}