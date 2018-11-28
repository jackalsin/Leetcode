package _0901_0950._947_Most_Stones_Removed_with_Same_Row_or_Column;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnionFindSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new UnionFindSolution();
  }

  @Test
  void testOnlineCase1() {
    final int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
    assertEquals(5, solution.removeStones(stones));
  }

  @Test
  void testOnlineCase2() {
    final int[][] stones = {{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}};
    assertEquals(3, solution.removeStones(stones));
  }

  @Test
  void testOnlineCase3() {
    final int[][] stones = {{0, 0}};
    assertEquals(0, solution.removeStones(stones));
  }
}