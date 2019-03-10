package _1001_1050._1001_Grid_Illumination._1005_Maximize_Sum_Of_Array_After_K_Negations;

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
    assertEquals(5, solution.largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
  }

  @Test
  void testOnlineCase2() {
    assertEquals(6, solution.largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
  }

  @Test
  void testOnlineCase3() {
    assertEquals(13, solution.largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
  }

  @Test
  void testOnlineCase4() {
    assertEquals(32, solution.largestSumAfterKNegations(new int[]{-2, 9, 9, 8, 4}, 5));
  }

  @Test
  void testOnlineCase5() {
    assertEquals(11,
        solution.largestSumAfterKNegations(new int[]{-2, 5, 0, 2, -2}, 3));
  }
}