package _0651_0700._685_Redundant_Connection_II;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
  @Test
  public void testOnlineCase1() throws Exception {
    Solution solution = new Solution();
    final int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
    final int[] actual = solution.findRedundantDirectedConnection(edges);
//    System.out.println(Arrays.toString(actual));
    assertArrayEquals(new int[]{2, 3}, actual);
  }

  @Test
  public void testOnlineCase2() throws Exception {
    Solution solution = new Solution();
    final int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
    final int[] actual = solution.findRedundantDirectedConnection(edges);
//    System.out.println(Arrays.toString(actual));
    assertArrayEquals(new int[]{4, 1}, actual);
  }

}
