package pinterest._685_Redundant_Connection_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
    final int[] actual = solution.findRedundantDirectedConnection(edges);
//    System.out.println(Arrays.toString(actual));
    assertArrayEquals(new int[]{2, 3}, actual);
  }

  @Test
  void testOnlineCase2() {
    final int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
    final int[] actual = solution.findRedundantDirectedConnection(edges);
//    System.out.println(Arrays.toString(actual));
    assertArrayEquals(new int[]{4, 1}, actual);
  }
}