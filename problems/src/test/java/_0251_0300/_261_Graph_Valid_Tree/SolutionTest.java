package _0251_0300._261_Graph_Valid_Tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 8/27/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testPositive() {
    final int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}};
    assertTrue(solution.validTree(5, edges));
  }

  @Test
  void testNegative() {
    final int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
    assertFalse(solution.validTree(5, edges));
  }

  @Test
  void test2Components() {
    final int[][] edges = new int[][]{{0, 1}, {2, 3}};
    assertFalse(solution.validTree(4, edges));
  }

  @Test
  void testFailed() {
    final int[][] edges = new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}};
    assertTrue(solution.validTree(5, edges));
  }
}
