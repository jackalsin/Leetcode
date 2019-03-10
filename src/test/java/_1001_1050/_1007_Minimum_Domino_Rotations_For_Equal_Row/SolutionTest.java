package _1001_1050._1007_Minimum_Domino_Rotations_For_Equal_Row;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/9/2019.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[] A = {2, 1, 2, 4, 2, 2}, B = {5, 2, 6, 2, 3, 2};
    assertEquals(2, solution.minDominoRotations(A, B));
  }

  @Test
  void testOnlineCase2() {
    final int[] A = {3, 5, 1, 2, 3}, B = {3, 6, 3, 3, 4};
    assertEquals(-1, solution.minDominoRotations(A, B));
  }

  @Test
  void testOnlineCase3() {
    final int[] A = {1, 2, 1, 1, 1, 2, 2, 2}, B = {2, 1, 2, 2, 2, 2, 2, 2};
    assertEquals(1, solution.minDominoRotations(A, B));
  }
}