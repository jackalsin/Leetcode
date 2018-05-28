package _501_550._523_Continuous_Subarray_Sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnineCase1() {
    assertTrue(solution.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
  }

  @Test
  void testEmpty() {
    assertFalse(solution.checkSubarraySum(new int[]{}, 6));
  }

  @Test
  void testSingleElement() {
    assertFalse(solution.checkSubarraySum(new int[]{6}, 6));
  }

  @Test
  void testNegative() {
    assertTrue(solution.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, -6));
  }

  @Test
  void test0() {
    assertFalse(solution.checkSubarraySum(new int[]{0, 1, 0}, 0));
  }

  @Test
  void test11() {
    assertTrue(solution.checkSubarraySum(new int[]{1, 1}, 2));
  }

  /**
   * Should keep the longest
   */
  @Test
  void test00() {
    assertTrue(solution.checkSubarraySum(new int[]{0, 0}, -1));
  }

}