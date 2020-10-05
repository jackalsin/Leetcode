package microsoft._174_Dungeon_Game;

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
  void test3By3() {
    final int[][] input = new int[][]{
        {-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}
    };
    assertEquals(7, solution.calculateMinimumHP(input));
  }
}