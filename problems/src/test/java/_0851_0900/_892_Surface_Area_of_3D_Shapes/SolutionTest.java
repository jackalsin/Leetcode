package _0851_0900._892_Surface_Area_of_3D_Shapes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[][] Input = {{2}};
    assertEquals(10, solution.surfaceArea(Input));
  }

  @Test
  void testOnlineCase2() {
    final int[][] Input = {{1, 2}, {3, 4}};
    assertEquals(34, solution.surfaceArea(Input));
  }

  @Test
  void testOnlineCase3() {
    final int[][] Input = {{1, 0}, {0, 2}};
    assertEquals(16, solution.surfaceArea(Input));
  }

  @Test
  void testOnlineCase4() {
    final int[][] Input = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    assertEquals(32, solution.surfaceArea(Input));
  }

  @Test
  void testOnlineCase5() {
    final int[][] Input = {{2, 2, 2}, {2, 1, 2}, {2, 2, 2}};
    assertEquals(46, solution.surfaceArea(Input));
  }
}