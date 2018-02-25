package interviews.uber._733_Flood_Fill;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[][] image = {
        {1, 1, 1},
        {1, 1, 0},
        {1, 0, 1}
    }, output = {
        {2, 2, 2},
        {2, 2, 0},
        {2, 0, 1}};
    final int sr = 1, sc = 1, newColor = 2;
    final int[][] actual = solution.floodFill(image, sr, sc, newColor);
    assertTrue(Arrays.deepEquals(output, actual));
  }

  @Test
  void testCentreIsNewColorNeighborNot() {
    final int[][] image = {
        {1, 2, 1},
        {2, 2, 0},
        {1, 0, 1}
    }, output = {
        {1, 2, 1},
        {2, 2, 0},
        {1, 0, 1}};
    final int sr = 1, sc = 1, newColor = 2;
    final int[][] actual = solution.floodFill(image, sr, sc, newColor);
    assertTrue(Arrays.deepEquals(output, actual));
  }

  @Test
  void testOnlineCase2() {
    final int[][] image = {
        {0, 0, 0},
        {0, 1, 1}
    }, output = {
        {0, 0, 0},
        {0, 1, 1}
    };
    final int sr = 1, sc = 1, newColor = 1;
    final int[][] actual = solution.floodFill(image, sr, sc, newColor);
    assertTrue(Arrays.deepEquals(output, actual));
  }

}