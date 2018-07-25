package _751_800._785_Is_Graph_Bipartite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
    assertTrue(solution.isBipartite(graph));
  }

  @Test
  void testOnlineCase2() {
    final int[][] graph = {
        {1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}
    };
    assertFalse(solution.isBipartite(graph));
  }


}