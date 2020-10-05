package pinterest._684_Redundant_Connection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    solution = new Solution();
    final int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
    final int[] actual = solution.findRedundantConnection(edges);
//    System.out.println(Arrays.toString(actual));
    assertArrayEquals(new int[]{2, 3}, actual);
  }

  @Test
  void testOnlineCase2() {
    solution = new Solution();
    final int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
    final int[] actual = solution.findRedundantConnection(edges);
//    System.out.println(Arrays.toString(actual));
    assertArrayEquals(new int[]{1, 4}, actual);
  }

  @Test
  void testFailedCase1() {
//    SampleSolution solution = new SampleSolution();
    Solution solution = new Solution();
    final int[][] edges = {{1, 4}, {3, 4}, {1, 3}, {1, 2}, {4, 5}};
    final int[] actual = solution.findRedundantConnection(edges);
//    System.out.println(Arrays.toString(actual));
    assertArrayEquals(new int[]{1, 3}, actual);
  }

  @Test
  void testFailedCase2() {
//    SampleSolution solution = new SampleSolution();
    Solution solution = new Solution();
    final int[][] edges = {{1, 3}, {1, 4}, {3, 4}, {1, 2}};
    final int[] actual = solution.findRedundantConnection(edges);
//    System.out.println(Arrays.toString(actual));
    assertArrayEquals(new int[]{3, 4}, actual);
  }
}