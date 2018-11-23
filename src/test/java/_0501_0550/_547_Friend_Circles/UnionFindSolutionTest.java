package _0501_0550._547_Friend_Circles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnionFindSolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new UnionFindSolution();
  }

  @Test
  void testOnlineCase1() {
    final int[][] Input = {{1, 1, 0},
        {1, 1, 0},
        {0, 0, 1}};
    assertEquals(2, solution.findCircleNum(Input));
  }

  @Test
  void testOnlineCase2() {
    final int[][] Input = {
        {1, 1, 0},
        {1, 1, 1},
        {0, 1, 1}};
    assertEquals(1, solution.findCircleNum(Input));
  }

  @Test
  void testOnlineCase3() {
    final int[][] Input = {
        {1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0},
        {0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
        {1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
        {1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
        {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
        {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0},
        {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
        {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
        {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1}
    };
    assertEquals(1, solution.findCircleNum(Input));
  }
}