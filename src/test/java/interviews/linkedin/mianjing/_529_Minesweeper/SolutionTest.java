package interviews.linkedin.mianjing._529_Minesweeper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TwoDimensionArray;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
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
    TwoDimensionArray.println(actual);
    assertTrue(Arrays.deepEquals(expected, actual));
  }

  @Test
  void testOnlineCase2() {
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
}