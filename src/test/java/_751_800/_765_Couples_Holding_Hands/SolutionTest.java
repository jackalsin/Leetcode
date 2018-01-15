package _751_800._765_Couples_Holding_Hands;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] row = {0, 2, 1, 3};
    assertEquals(1, solution.minSwapsCouples(row));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] row = {3, 2, 0, 1};
    assertEquals(0, solution.minSwapsCouples(row));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final int[] row = {2, 0, 5, 4, 3, 1};
    assertEquals(1, solution.minSwapsCouples(row));
  }

  @Test
  public void testFailedCase2() throws Exception {
    final int[] row = {1, 4, 0, 5, 8, 7, 6, 3, 2, 9};
    assertEquals(3, solution.minSwapsCouples(row));
  }

  @Test
  public void testFailedCase3() {
    final int[] row = {6, 2, 1, 7, 4, 5, 3, 8, 0, 9};
    assertEquals(3, solution.minSwapsCouples(row));
  }

  @Test
  public void testFailedCase4() {
    final int[] row = {15, 13, 5, 6, 3, 12, 1, 10, 16, 2, 8, 17, 7, 11, 0, 9, 14, 4};
    assertEquals(8, solution.minSwapsCouples(row));
  }

  @Test
  public void testFailedCase5() {
    final int[] row = {12, 11, 9, 0, 23, 7, 1, 22, 21, 18, 15, 16, 14, 2, 17, 19, 13, 8, 5, 3, 6,
        4, 20, 10};
    assertEquals(11, solution.minSwapsCouples(row));
  }

  @Test
  public void testTLECase1() {
    final int[] row = {28, 4, 37, 54, 35, 41, 43, 42, 45, 38, 19, 51, 49, 17, 47, 25, 12, 53, 57,
        20, 2, 1, 9, 27, 31, 55,
        32, 48, 59, 15, 14, 8, 3, 7, 58, 23, 10, 52, 22, 30, 6, 21, 24, 16, 46, 5, 33, 56, 18,
        50, 39, 34, 29, 36, 26, 40, 44, 0, 11, 13};
    assertEquals(26, solution.minSwapsCouples(row));
  }
}
