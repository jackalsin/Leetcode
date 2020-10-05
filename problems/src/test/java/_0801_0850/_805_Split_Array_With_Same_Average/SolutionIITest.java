package _0801_0850._805_Split_Array_With_Same_Average;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionIITest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionII();
  }

  @Test
  void testOnlineCase1() {
    assertTrue(solution.splitArraySameAverage(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
  }

  @Test
  void testTLE1() {
    final int[] nums = {60, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
    final long startTime = System.nanoTime();
    assertFalse(solution.splitArraySameAverage(nums));
    final long endTime = System.nanoTime();
    System.out.println(this.getClass().getPackage() + " Execution Time = " + ((endTime - startTime) / 1e6) + "ms");
  }

  @Test
  void testTLE2() {
    final int[] nums = {904, 8738, 6439, 1889, 138, 5771, 8899, 5790, 662, 8402, 3074, 1844, 5926, 8720, 7159, 6793, 7402, 9466, 1282, 1748, 434, 842, 22};
    final long startTime = System.nanoTime();
    assertFalse(solution.splitArraySameAverage(nums));
    final long endTime = System.nanoTime();
    System.out.println(this.getClass().getPackage() + " Execution Time = " + ((endTime - startTime) / 1e6) + "ms");
  }

  @Test
  void testOnlineCase3() {
    final int[] nums = {72, 56, 81, 54, 15, 96, 80, 90, 8};
    assertTrue(solution.splitArraySameAverage(nums));
  }
}