package _451_500._465_Optimal_Account_Balancing;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[][] trans = {{0, 1, 10}, {2, 0, 5}};
    assertEquals(2, solution.minTransfers(trans));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[][] trans = {{0, 1, 10}, {1, 0, 1}, {1, 2, 5}, {2, 0, 5}};
    assertEquals(1, solution.minTransfers(trans));
  }

  @Test
  public void testDfs() throws Exception {
    final List<Integer> debt = new ArrayList<>(List.of(5, 4, 3, -10, -2));
    assertEquals(4, solution.dfs(debt, 0, 0));

  }

  @Test
  public void testFailedCase1() throws Exception {
    final int[][] trans = {{2, 0, 5}, {3, 4, 4}};
    assertEquals(2, solution.minTransfers(trans));
  }

}