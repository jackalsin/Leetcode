package interviews.uber._054_Spiral_Matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TwoDimensionArray;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/15/2018.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testEmpty() {
    assertEquals(Collections.emptyList(), solution.spiralOrder(new int[][] {}));
  }

  @Test
  void testWith3By3() {
    assertEquals(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5), solution.spiralOrder(get2dBoard(3, 3)));
  }

  @Test
  void testWith5by5() {
    assertEquals(Arrays.asList(1, 2, 3, 4, 5, 10, 15, 20, 25, 24, 23, 22, 21, 16, 11, 6, 7, 8, 9,
        14, 19, 18, 17, 12,
        13), solution.spiralOrder(get2dBoard(5, 5)));
  }

  @Test
  public void testWith4by4() {
    assertEquals(Arrays.asList(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10), solution
        .spiralOrder(get2dBoard(4, 4)));
  }

  @Test
  public void testWith1by2() {
    assertEquals(Arrays.asList(2, 3), solution.spiralOrder(new int[][] {{2, 3}}));
  }

  @Test
  public void testWith3by1() {
    assertEquals(Arrays.asList(1, 2, 3), solution.spiralOrder(new int[][] {{1}, {2}, {3}}));
  }

  private int[][] get2dBoard(int rows, int cols) {
    int[][] result = new int[rows][cols];
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        result[row][col] = row * cols + col + 1;
      }
    }
    TwoDimensionArray.toString(result);
    return result;
  }

}
