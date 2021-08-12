package microsoft._048_Rotate_Image;

import definition.TwoDimensionArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testWithEmptySquare() {
    int[][] actual = new int[][]{};
    solution.rotate(actual);
    assertTrue(TwoDimensionArray.TwoDimensionArrayEquals(new int[][]{}, actual));
  }

  @Test
  void testWithSingleElementSquare() {
    int[][] expected = new int[][]{{1}};
    int[][] actual = new int[][]{{1}};
    solution.rotate(actual);
    assertTrue(TwoDimensionArray.TwoDimensionArrayEquals(expected, actual));
  }

  @Test
  void testWith2by2Matrix() {
    int[][] expected = new int[][]{{3, 1}, {4, 2}};
    int[][] actual = new int[][]{{1, 2}, {3, 4}};
    solution.rotate(actual);
    assertTrue(TwoDimensionArray.TwoDimensionArrayEquals(expected, actual));
  }

  @Test
  void testWith4by4Matrix() {
    int[][] expected = new int[][]{
        {13, 9, 5, 1},
        {14, 10, 6, 2},
        {15, 11, 7, 3},
        {16, 12, 8, 4}
    };
    int[][] actual = new int[][]{
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}};
    solution.rotate(actual);
    assertTrue(TwoDimensionArray.TwoDimensionArrayEquals(expected, actual));
  }

}