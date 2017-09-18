package _301_350._310_Minimum_Height_Trees;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/16/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new BfsSolution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
    assertEquals(Collections.singletonList(1), solution.findMinHeightTrees(4, edges));
  }

  @Test
  public void testEmpty() throws Exception {
    assertEquals(Collections.singletonList(0), solution.findMinHeightTrees(1, new int[][] {}));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    // Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]] 
    final int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4} };
    assertEquals(Arrays.asList(3, 4), solution.findMinHeightTrees(6, edges));   
  }
}
