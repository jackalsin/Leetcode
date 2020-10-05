package microsoft._215_Kth_Largest_Element_in_an_Array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new ONSolution();
  }

  @Test
  void testOneElement() {
    final int[] input = new int[]{1};
    assertEquals(1, solution.findKthLargest(input, 1));
  }

  @Test
  void testOnlineCase() {
    final int[] input = new int[]{3, 2, 1, 5, 6, 4};
    assertEquals(5, solution.findKthLargest(input, 2));
  }

  @Test
  void testDuplicate() {
    final int[] input = new int[]{1, 2, 3, 4, 5, 5, 5, 6};
    assertEquals(5, solution.findKthLargest(input, 2));
    assertEquals(4, solution.findKthLargest(input, 5));
  }

  @Test
  void testFailedCase() {
    final int[] input = new int[]{7, 6, 5, 4, 3, 2, 1};
    assertEquals(6, solution.findKthLargest(input, 2));
  }

  @Test
  void testFailedCase1() {
    final int[] input = new int[]{7, 6, 5, 4, 3, 2, 1};
    assertEquals(3, solution.findKthLargest(input, 5));
  }

  @Test
  void testFailedCase2() {
    final int[] input = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6};
    assertEquals(10, solution.findKthLargest(input, 2));
  }

}