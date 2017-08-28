package _251_300._261_Graph_Valid_Tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 8/27/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testPositive() throws Exception {
     final int[][] edges = new int[][] {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
     assertTrue(solution.validTree(5, edges));
  }

  @Test
  public void testNegative() throws Exception {
    final int[][] edges = new int[][] {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
    assertFalse(solution.validTree(5, edges));
  }

  @Test
  public void test2Components() throws Exception {
    final int[][] edges = new int[][] {{0, 1}, {2, 3}};
    assertFalse(solution.validTree(4, edges));
  }

  @Test
  public void testFailed() throws Exception {
    final int[][] edges = new int[][] {{0,1},{0,2},{2,3},{2,4}};
    assertTrue(solution.validTree(5, edges));
  }
}
