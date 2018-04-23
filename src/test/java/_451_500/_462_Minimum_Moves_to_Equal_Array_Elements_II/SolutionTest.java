package _451_500._462_Minimum_Moves_to_Equal_Array_Elements_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
//    solution = new WrongSolution();
//    solution = new RightSolution();
    solution = new QuickSelectionSolution();
  }

  @Test
  void testOnlineCase1() {
    final int[] nums = {1, 2, 3};
    assertEquals(2, solution.minMoves2(nums));
  }

  @Test
  void testOnlineCase2() {
    final int[] nums = {1, 2, 4};
    assertEquals(3, solution.minMoves2(nums));
  }

  /**
   * This case is for the wrong solution.
   * <p>
   * The target for the wrong solution will be 3, so the result will be 16.
   * <p>
   * However, if the target becomes 1, the result will be 14.
   */
  @Test
  void testFailedCase1() {
    final int[] nums = {1, 0, 0, 8, 6};
    assertEquals(14, solution.minMoves2(nums));
  }

  @Test
  void testFailedCase2() {
    final int[] nums = {1};
    assertEquals(0, solution.minMoves2(nums));

  }
}