package google._085_Maximal_Rectangle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/7/2020
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
  void testOnline3(Solution solution) {
    final String input =
        "1 1 1 0 0 0 0 0\n" +
            "1 1 1 1 1 1 1 1\n" +
            "0 0 0 0 1 1 1 1\n" +
            "0 0 0 0 1 1 1 1";
    char[][] inputBoard = getBoard(input);
    assertEquals(12, solution.maximalRectangle(inputBoard));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnline4(Solution solution) {
    final String input =
        "1 1 1 0 0 0 0 0\n" +
            "1 1 1 1 1 1 1 1\n" +
            "1 1 0 0 1 1 1 1\n" +
            "0 0 0 0 1 1 1 1";
    char[][] inputBoard = getBoard(input);
    assertEquals(12, solution.maximalRectangle(inputBoard));
  }

  private char[][] getBoard(String strBoard) {
    String[] rowLines = strBoard.split("\n");
    int rows = rowLines.length;
    int cols = rowLines[0].split(" ").length;
    char[][] result = new char[rows][cols];
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        result[row][col] = rowLines[row].split(" ")[col].charAt(0);
      }
    }
    return result;
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}