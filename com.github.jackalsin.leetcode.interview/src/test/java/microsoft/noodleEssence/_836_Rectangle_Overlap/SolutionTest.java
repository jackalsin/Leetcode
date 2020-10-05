package microsoft.noodleEssence._836_Rectangle_Overlap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {

    final int[] rec1 = {0, 0, 2, 2}, rec2 = {1, 1, 3, 3};
    assertTrue(solution.isRectangleOverlap(rec1, rec2));
  }

  @Test
  void testOnlineCase2() {
    final int[] rec1 = {0, 0, 1, 1}, rec2 = {1, 0, 2, 1};
    assertFalse(solution.isRectangleOverlap(rec1, rec2));
  }

  @Test
  void testFailedCase1() {
    final int[] rec1 = {2, 17, 6, 20}, rec2 = {3, 8, 6, 20};
    assertTrue(solution.isRectangleOverlap(rec1, rec2));
  }

  @Test
  void testFailedCase2() {
    final int[] rec1 = {5, 15, 8, 18}, rec2 = {0, 3, 7, 9};
    assertFalse(solution.isRectangleOverlap(rec1, rec2));
  }

}