package interviews.airbnb._221_Maximal_Square;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TwoDimensionArray;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/31/2019.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase() throws Exception {
    final char[][] board = TwoDimensionArray.getCharBoard(new String[]{
        "10100", "10111", "11111", "10010"
    });
    assertEquals(4, solution.maximalSquare(board));
  }

  @Test
  void testOnlineCaseOFailed() throws Exception {
    final char[][] board = TwoDimensionArray.getCharBoard(new String[]{
        "1010", "1011", "1011", "1111"
    });
    assertEquals(4, solution.maximalSquare(board));
  }

  @Test
  void testFailed() throws Exception {
    final char[][] board = TwoDimensionArray.getCharBoard(new String[]{
        "10", "01", "01", "01", "11", "00", "01"
    });
    assertEquals(1, solution.maximalSquare(board));
  }
}