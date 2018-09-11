package interviews.linkedin._323_Number_of_Connected_Components_in_an_Undirected_Graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() throws Exception {
    final int n = 5;
    final int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
    assertEquals(2, solution.countComponents(5, edges));
  }

  @Test
  void testOnlineCase2() throws Exception {
    final int n = 5;
    final int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
    assertEquals(1, solution.countComponents(5, edges));
  }

}