package _0151_0200._154_Find_Minimum_in_Rotated_Sorted_Array_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/17/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  // non duplicated test cases
  @Test
  void testOneElement() throws Exception {
    final int[] input = new int[]{1};
    assertEquals(1, solution.findMin(input));
  }

  @Test
  void testTwoElement() throws Exception {
    final int[] input = new int[]{1, 2};
    assertEquals(1, solution.findMin(input));
  }

  @Test
  void testTwoElements() throws Exception {
    final int[] input = new int[]{2, 1};
    assertEquals(1, solution.findMin(input));
  }

  @Test
  void test5Elements() throws Exception {
    final int[] input = new int[]{2, 3, 4, 0, 1};
    assertEquals(0, solution.findMin(input));
  }

  // duplicated test cases

}