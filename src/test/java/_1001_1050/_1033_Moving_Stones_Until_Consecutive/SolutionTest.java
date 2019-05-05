package _1001_1050._1033_Moving_Stones_Until_Consecutive;

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
    final int[] expected = {1, 2};
    assertArrayEquals(expected, solution.numMovesStones(1, 2, 5));
  }

  @Test
  void testOnlineCase2() {
    final int[] expected = {0, 0};
    assertArrayEquals(expected, solution.numMovesStones(4, 3, 2));
  }

  @Test
  void testOnlineCase3() {
    final int[] expected = {1, 2};
    assertArrayEquals(expected, solution.numMovesStones(3, 5, 1));
  }

}