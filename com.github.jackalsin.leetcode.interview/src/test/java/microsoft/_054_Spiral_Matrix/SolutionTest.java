package microsoft._054_Spiral_Matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testWith3By3() throws Exception {
    assertEquals(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5), solution.spiralOrder(get2dBoard(3, 3)));
  }

  @Test
  void testWith5by5() throws Exception {
    assertEquals(Arrays.asList(1, 2, 3, 4, 5, 10, 15, 20, 25, 24, 23, 22, 21, 16, 11, 6, 7, 8, 9, 14, 19, 18, 17, 12,
        13), solution.spiralOrder(get2dBoard(5, 5)));
  }

  @Test
  void testWith4by4() throws Exception {
    assertEquals(Arrays.asList(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10), solution.spiralOrder(get2dBoard(4, 4)));
  }

  @Test
  void testWith1by2() throws Exception {
    assertEquals(Arrays.asList(2, 3), solution.spiralOrder(new int[][]{{2, 3}}));
  }

  @Test
  void testWith3by1() throws Exception {
    assertEquals(Arrays.asList(1, 2, 3), solution.spiralOrder(new int[][]{{1}, {2}, {3}}));
  }

  private int[][] get2dBoard(int rows, int cols) {
    int[][] result = new int[rows][cols];
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        result[row][col] = row * cols + col + 1;
      }
    }
    return result;
  }
}