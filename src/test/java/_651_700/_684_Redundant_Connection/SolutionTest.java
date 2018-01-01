package _651_700._684_Redundant_Connection;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testOnlineCase1() throws Exception {
    solution = new Solution();
    final int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
    final int[] actual = solution.findRedundantConnection(edges);
//    System.out.println(Arrays.toString(actual));
    assertArrayEquals(new int[]{2, 3}, actual);
  }

  @Test
  public void testOnlineCase2() throws Exception {
    solution = new Solution();
    final int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
    final int[] actual = solution.findRedundantConnection(edges);
//    System.out.println(Arrays.toString(actual));
    assertArrayEquals(new int[]{1, 4}, actual);
  }

  @Test
  public void testFailedCase1() throws Exception {

//    SampleSolution solution = new SampleSolution();
    Solution solution = new Solution();
    final int[][] edges = {{1, 4}, {3, 4}, {1, 3}, {1, 2}, {4, 5}};
    final int[] actual = solution.findRedundantConnection(edges);
    System.out.println(Arrays.toString(actual));
    assertArrayEquals(new int[]{1, 3}, actual);
  }

  @Test
  public void testFailedCase2() throws Exception {

//    SampleSolution solution = new SampleSolution();
    Solution solution = new Solution();
    final int[][] edges = {{1, 3}, {1, 4}, {3, 4}, {1, 2}};
    final int[] actual = solution.findRedundantConnection(edges);
    System.out.println(Arrays.toString(actual));
    assertArrayEquals(new int[]{3, 4}, actual);
  }
}
