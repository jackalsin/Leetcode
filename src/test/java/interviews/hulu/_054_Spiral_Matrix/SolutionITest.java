package interviews.hulu._054_Spiral_Matrix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/13/2019
 */
class SolutionITest {
  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testWith3By3(Solution solution) {
    assertEquals(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5), solution.spiralOrder(get2dBoard(3, 3)));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testWith5by5(Solution solution) {
    assertEquals(Arrays.asList(1, 2, 3, 4, 5, 10, 15, 20, 25, 24, 23, 22, 21, 16, 11, 6, 7, 8, 9, 14, 19, 18, 17, 12,
        13), solution.spiralOrder(get2dBoard(5, 5)));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testWith4by4(Solution solution) {
    assertEquals(Arrays.asList(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10),
        solution.spiralOrder(get2dBoard(4, 4)));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testWith1by2(Solution solution) {
    assertEquals(Arrays.asList(2, 3), solution.spiralOrder(new int[][]{{2, 3}}));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testWith3by1(Solution solution) {
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

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}