package microsoft._200_Number_of_Islands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testExample1() {
    final char[][] grid = getCharBoard(new String[]{
        "11110",
        "11010",
        "11000",
        "00000"
    });
    assertEquals(1, solution.numIslands(grid));
  }

  @Test
  void testExample2() {
    final char[][] grid = getCharBoard(new String[]{
        "11000",
        "11000",
        "00100",
        "00011"
    });
    assertEquals(3, solution.numIslands(grid));
  }

  @Test
  void testEmpty() {
    final char[][] grid = new char[][]{{}};
    assertEquals(0, solution.numIslands(grid));
  }


  private static char[][] getCharBoard(String[] input) {
    char[][] board = new char[input.length][input[0].length()];

    for (int row = 0; row < input.length; row++) {
      for (int col = 0; col < input[row].length(); col++) {
        board[row][col] = input[row].charAt(col);
      }
    }
    return board;
  }

}