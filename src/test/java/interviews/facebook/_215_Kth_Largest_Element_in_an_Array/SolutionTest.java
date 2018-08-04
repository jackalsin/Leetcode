package interviews.facebook._215_Kth_Largest_Element_in_an_Array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
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


  // test of partition
  @Test
  void testPartition1() {
    final int[] input = {2, 3, 4, 2, 5};
    final int pI = solution.partition(input, 0, input.length - 1);
//    System.out.println(Arrays.toString(input));
    assertEquals(4, pI);
  }

  @Test
  void testPartition2() {
    final int[] input = {2, 3, 4, 2, 5};
    final int pI = solution.partition(input, 1, input.length - 1);
//    System.out.println(Arrays.toString(input));
    assertEquals(4, pI);
  }

  @Test
  void testPartition3() {
    final int[] input = {2, 3, 4, 2, 5};
    final int pI = solution.partition(input, 2, input.length - 1);
//    System.out.println(Arrays.toString(input));
    assertEquals(4, pI);
  }

  @Test
  void testPartition4() {
    final int[] input = {4, 1, 2, 3};
    final int pI = solution.partition(input, 0, input.length - 1);
//    System.out.println(Arrays.toString(input));
    assertEquals(2, pI);
  }
}