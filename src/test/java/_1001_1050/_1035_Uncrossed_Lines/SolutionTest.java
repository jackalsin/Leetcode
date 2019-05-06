package _1001_1050._1035_Uncrossed_Lines;

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
    final int[] A = {1, 4, 2}, B = {1, 2, 4};
    assertEquals(2, solution.maxUncrossedLines(A, B));
  }

  @Test
  void testOnlineCase2() {
    final int[] A = {2, 5, 1, 2, 5}, B = {10, 5, 2, 1, 5, 2};
    assertEquals(3, solution.maxUncrossedLines(A, B));
  }

  @Test
  void testOnlineCase3() {
    final int[] A = {1, 3, 7, 1, 7, 5}, B = {1, 9, 2, 5, 1};
    assertEquals(2, solution.maxUncrossedLines(A, B));
  }
}