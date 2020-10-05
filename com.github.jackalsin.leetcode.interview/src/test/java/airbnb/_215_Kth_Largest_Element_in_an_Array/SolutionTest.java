package airbnb._215_Kth_Largest_Element_in_an_Array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/27/2019.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testOneElement() throws Exception {
    final int[] input = new int[]{1};
    assertEquals(1, solution.findKthLargest(input, 1));
  }

  @Test
  void testOnlineCase() throws Exception {
    final int[] input = new int[]{3, 2, 1, 5, 6, 4};
    assertEquals(5, solution.findKthLargest(input, 2));
  }

  @Test
  void testDuplicate() throws Exception {
    final int[] input = new int[]{1, 2, 3, 4, 5, 5, 5, 6};
    assertEquals(5, solution.findKthLargest(input, 2));
    assertEquals(4, solution.findKthLargest(input, 5));
  }

  @Test
  void testFailedCase1() throws Exception {
    final int[] input = new int[]{7, 6, 5, 4, 3, 2, 1};
    assertEquals(6, solution.findKthLargest(input, 2));
  }
}