package _0701_0750._733_Flood_Fill;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/5/2018.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() throws Exception {
    final int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, output = {{2, 2, 2}, {2, 2, 0}, {2,
        0, 1}};
    final int sr = 1, sc = 1, newColor = 2;
    final int[][] actual = solution.floodFill(image, sr, sc, newColor);
    assertTrue(Arrays.deepEquals(output, actual));
  }

  @Test
  void testOnlineCase2() throws Exception {
    final int[][] image = {{0, 0, 0}, {0, 1, 1}}, output = {{0, 0, 0}, {0, 1, 1}};
    final int sr = 1, sc = 1, newColor = 1;
    final int[][] actual = solution.floodFill(image, sr, sc, newColor);
    assertTrue(Arrays.deepEquals(output, actual));
  }
}
