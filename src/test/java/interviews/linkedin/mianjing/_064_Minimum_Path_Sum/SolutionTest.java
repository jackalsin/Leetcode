package interviews.linkedin.mianjing._064_Minimum_Path_Sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testWith1By1() {
    assertEquals(0, solution.minPathSum(new int[][]{{0}}));
  }

  @Test
  void testWith3By3() {
    assertEquals(9, solution.minPathSum(new int[][]{
        {1, 2, 3},
        {2, 4, 1},
        {3, 1, 2}
    }));
  }

  @Test
  void testWith3by1() {
    assertEquals(4, solution.minPathSum(new int[][]{
        {0, 1, 3}
    }));
  }
}