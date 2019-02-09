package _0401_0450._410_Split_Array_Largest_Sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/7/2019.
 */
class DpSolutionIITest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new DpSolutionII();
  }

  @Test
  void testOnlineCase1() throws Exception {
    final int[] nums = {1, 2, 3, 6};
    assertEquals(6, solution.splitArray(nums, 2));
  }

  @Test
  void testOnlineCase2() throws Exception {
    final int[] nums = {7, 2, 5, 10, 8};
    assertEquals(18, solution.splitArray(nums, 2));
  }
}