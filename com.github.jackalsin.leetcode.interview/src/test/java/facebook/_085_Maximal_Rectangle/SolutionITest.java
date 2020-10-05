package facebook._085_Maximal_Rectangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TwoDimensionArray;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionITest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionI();
  }

  @Test
  void testOnlineCase() {
    final char[][] board = new char[][]{
        {'0', '0', '0', '1', '0', '0', '0'},
        {'0', '0', '1', '1', '1', '0', '0'},
        {'0', '1', '1', '1', '1', '1', '0'}
    };

    assertEquals(6, solution.maximalRectangle(board));
  }

  @Test
  void testOnlineCase2() {

    final char[][] board = new char[][]{
        {'0', '0', '0', '1', '0', '0', '0'},
        {'0', '0', '1', '1', '1', '0', '0'},
        {'0', '1', '1', '1', '1', '1', '0'}
    };

    assertEquals(6, solution.maximalRectangle(board));
  }

  @Test
  void testOnline3() {
    final String input =
        "1 1 1 0 0 0 0 0\n" +
            "1 1 1 1 1 1 1 1\n" +
            "0 0 0 0 1 1 1 1\n" +
            "0 0 0 0 1 1 1 1";
    char[][] inputBoard = getBoard(input);
    assertEquals(12, solution.maximalRectangle(inputBoard));
  }

  @Test
  void testOnline4() {
    final String input =
        "1 1 1 0 0 0 0 0\n" +
            "1 1 1 1 1 1 1 1\n" +
            "1 1 0 0 1 1 1 1\n" +
            "0 0 0 0 1 1 1 1";
    char[][] inputBoard = getBoard(input);
    assertEquals(12, solution.maximalRectangle(inputBoard));
  }

  // ------ test get board ----
  @Test
  void testGetBoard() {
    final String input = "1 1 1 0 0 0 0 0\n" +
        "1 1 1 1 1 1 1 1\n" +
        "0 0 0 0 1 1 1 1\n" +
        "0 0 0 0 1 1 1 1\n";
    char[][] expected = new char[][]{
        {'1', '1', '1', '0', '0', '0', '0', '0'},
        {'1', '1', '1', '1', '1', '1', '1', '1'},
        {'0', '0', '0', '0', '1', '1', '1', '1'},
        {'0', '0', '0', '0', '1', '1', '1', '1'},
    };
    assertTrue(TwoDimensionArray.TwoDimensionArrayEquals(expected, getBoard(input)));
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
}