package _0801_0850._803_Bricks_Falling_When_Hit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DfsSolutionTest {

  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new DfsSolution();
  }

  @Test
  void testOnlineCase1() {
    final int grid[][] = {
        {1, 0, 0, 0},
        {1, 1, 1, 0}
    }, hits[][] = {
        {1, 0}
    }, expected[] = {2};
    final int[] actual = solution.hitBricks(grid, hits);
    assertArrayEquals(expected, actual);
  }

  @Test
  void testOnlineCase2() {
    final int grid[][] = {{1, 0, 0, 0}, {1, 1, 0, 0}}, hits[][] = {{1, 1}, {1, 0}}, expected[] = {0, 0};
    final int[] actual = solution.hitBricks(grid, hits);
    assertArrayEquals(expected, actual);
  }

  @Test
  void testOnlineCase3() {
    final int grid[][] = {{1, 0, 1, 0}, {1, 1, 1, 0}}, hits[][] = {{1, 0}}, expected[] = {0};
    final int[] actual = solution.hitBricks(grid, hits);
    assertArrayEquals(expected, actual);
  }

  @Test
  void testOnlineCase4() {
    final int grid[][] = {{1}, {1}, {1}, {1}, {1}},
        hits[][] = {{3, 0}, {4, 0}, {1, 0}, {2, 0}, {0, 0}},
        expected[] = {1, 0, 1, 0, 0};
    final int[] actual = solution.hitBricks(grid, hits);
    assertArrayEquals(expected, actual);
  }

  @Test
  void testOnlineCase5() {

    final int grid[][] = {{0, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}},
        hits[][] = {{1, 3}, {3, 5}, {0, 3}, {3, 3}, {1, 1}, {4, 2}, {1, 0}, {3, 0}, {4, 5}, {2, 1}, {4, 4}, {4, 0}, {2, 4}, {2, 5}, {3, 4}, {0, 5}, {0,
            4}, {3, 2}, {1, 5}, {4, 1}, {2, 2}, {0, 2}},
        expected[] = {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1};
    final int[] actual = solution.hitBricks(grid, hits);
    assertArrayEquals(expected, actual);
  }
}