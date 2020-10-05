package pinterest._200_Number_of_Islands;

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

  @Test
  void testTLE() {
    final char[][] grid = getCharBoard(new String[]{
        "11111011111111101011",
        "01111111111110111110",
        "10111001101111111111",
        "11110111111111111111",
        "10011111111111111111",
        "10111111011101110111",
        "01111111111101101111",
        "11111111111101111011",
        "11111111110111111111",
        "11111111111111111111",
        "01111111011111111111",
        "11111111111111111111",
        "11111111111111111111",
        "11111011111110111111",
        "10111110111011110111",
        "11111111111101111110",
        "11111111111110111100",
        "11111111111111111111",
        "11111111111111111111",
        "11111111111111111111"
    });
    assertEquals(1, solution.numIslands(grid));
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