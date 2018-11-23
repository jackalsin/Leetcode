package _0001_0050._034_Search_for_a_Range;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 2/15/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testWithSingleIndex() {
    final int[] input = new int[]{1, 2, 3, 4, 5};
    assertArrayEquals(new int[]{2, 2}, solution.searchRange(input, 3));
  }

  @Test
  void testWithNotFoundSingleValue() {
    final int[] input = new int[]{1, 2, 3, 4, 5};
    assertArrayEquals(new int[]{-1, -1}, solution.searchRange(input, -1));
  }

  @Test
  void testWithDupFindValue() {
    final int[] input = new int[]{1, 2, 3, 3, 3, 4, 5};
    assertArrayEquals(new int[]{2, 4}, solution.searchRange(input, 3));
  }

  @Test
  void testWithSingleValueArrayOdd() {
    final int[] input = new int[]{1};
    assertArrayEquals(new int[]{0, 0}, solution.searchRange(input, 1));
  }

  @Test
  void testWithSingleValueArrayEven() {
    final int[] input = new int[]{2};
    assertArrayEquals(new int[]{0, 0}, solution.searchRange(input, 2));
  }
}