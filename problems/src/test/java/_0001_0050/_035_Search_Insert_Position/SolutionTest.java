package _0001_0050._035_Search_Insert_Position;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/15/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  // non-exist value
  @Test
  void testWithLeadingValue() throws Exception {
    final int[] input = new int[]{1, 3, 5, 7, 9};
    assertEquals(0, solution.searchInsert(input, 0));
  }

  @Test
  void testWithTrailingValue() throws Exception {
    final int[] input = new int[]{1, 3, 5, 7, 9};
    assertEquals(5, solution.searchInsert(input, 10));
  }

  @Test
  void testWithMidMissingValue() throws Exception {
    final int[] input = new int[]{1, 3, 5, 7, 9};
    assertEquals(3, solution.searchInsert(input, 6));
  }
  //test for existing value

  @Test
  void testWith0thValue() throws Exception {
    final int[] input = new int[]{1, 3, 5, 7, 9};
    assertEquals(0, solution.searchInsert(input, 1));
  }

  @Test
  void testWithLastValue() throws Exception {
    final int[] input = new int[]{1, 3, 5, 7, 9};
    assertEquals(4, solution.searchInsert(input, 9));
  }

  @Test
  void testWithMidValue() throws Exception {
    final int[] input = new int[]{1, 3, 5, 7, 9};
    assertEquals(2, solution.searchInsert(input, 5));
  }

}