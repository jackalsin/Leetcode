package _0751_0800._765_Couples_Holding_Hands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new DfsCacheSolution();
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
    long startTime = System.nanoTime();
    final int[] row = {28, 4, 37, 54, 35, 41, 43, 42, 45, 38, 19, 51, 49, 17, 47, 25, 12, 53, 57,
        20, 2, 1, 9, 27, 31, 55,
        32, 48, 59, 15, 14, 8, 3, 7, 58, 23, 10, 52, 22, 30, 6, 21, 24, 16, 46, 5, 33, 56, 18,
        50, 39, 34, 29, 36, 26, 40, 44, 0, 11, 13};
    int actual = solution.minSwapsCouples(row);
    long endTime = System.nanoTime();
    System.out.println("Actual time = " + ((endTime - startTime) / 1E6) + "ms.");
    assertEquals(26, actual);
  }

  @Test
  public void testTLECase2() {
    long startTime = System.nanoTime();
    final int[] row = {7, 17, 37, 34, 11, 14, 15, 26, 32, 58, 28, 1, 56, 10, 22, 16, 24, 41, 4,
        39, 2, 50, 21, 6, 38, 44,
        29, 8, 45, 59, 36, 49, 30, 25, 57, 18, 40, 55, 3, 13, 20, 54, 33, 12, 51, 35, 42, 9, 53,
        52, 43, 19, 5, 46, 48, 31, 47, 0, 27, 23};
    int actual = solution.minSwapsCouples(row);
    long endTime = System.nanoTime();
    System.out.println("Actual time = " + ((endTime - startTime) / 1E6) + "ms.");
    assertEquals(28, actual);
  }

  @Test
  public void testTLECase3() {
    long startTime = System.nanoTime();
    final int[] row = {43, 12, 47, 7, 33, 54, 4, 51, 24, 46, 34, 56, 3, 29, 21, 42, 15, 52, 0, 8,
        18, 35, 13, 5, 9, 41, 44, 1, 32, 45, 23, 53, 11, 50, 58, 16, 40, 26, 27, 20, 14, 31, 37,
        25, 2, 48, 17, 39, 30, 28, 38, 55, 59, 19, 6, 57, 36, 49, 22, 10};
    int actual = solution.minSwapsCouples(row);
    long endTime = System.nanoTime();
    System.out.println("Actual time = " + ((endTime - startTime) / 1E6) + "ms.");
    assertEquals(29, actual);
  }
}
