package facebook._221_Maximal_Square;

import definition.TwoDimensionArray;
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
  void testOnlineCase() {
    final char[][] board = TwoDimensionArray.getCharBoard(new String[]{
        "10100", "10111", "11111", "10010"
    });

    assertEquals(4, solution.maximalSquare(board));
  }

  @Test
  void testOnlineCaseOFailed() {
    final char[][] board = TwoDimensionArray.getCharBoard(new String[]{
        "1010", "1011", "1011", "1111"
    });

    assertEquals(4, solution.maximalSquare(board));
  }

  @Test
  void testFailed() {
    final char[][] board = TwoDimensionArray.getCharBoard(new String[]{
        "10", "01", "01", "01", "11", "00", "01"
    });

    assertEquals(1, solution.maximalSquare(board));

  }

  @Test
  void testFailed2() {
    final char[][] board = {
        {'1', '0', '1', '0', '0'},
        {'1', '0', '1', '1', '1'},
        {'1', '1', '1', '1', '1'},
        {'1', '0', '0', '1', '0'}
    };
    assertEquals(4, solution.maximalSquare(board));

  }

  @Test
  void testFailed3() {
    final char[][] board = {
        {'1', '0', '1', '0', '0'},
        {'1', '0', '1', '1', '1'},
        {'1', '1', '1', '1', '1'},
        {'1', '0', '0', '1', '0'}
    };
    assertEquals(4, solution.maximalSquare(board));

  }
}