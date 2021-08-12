package google._215_Kth_Largest_Element_in_an_Array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/31/2018.
 */
public class SolutionTest {

  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOneElement() {
    final int[] input = new int[]{1};
    assertEquals(1, solution.findKthLargest(input, 1));
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int[] input = new int[]{3, 2, 1, 5, 6, 4};
    assertEquals(5, solution.findKthLargest(input, 2));
  }

  @Test
  public void testDuplicate() {
    final int[] input = new int[]{1, 2, 3, 4, 5, 5, 5, 6};
    assertEquals(5, solution.findKthLargest(input, 2));
    assertEquals(4, solution.findKthLargest(input, 5));
  }

  @Test
  public void testDuplicateReflected() {
    final int[] input = new int[]{1, 2, 2, 3, 3, 3, 4, 4, 5};
    assertEquals(4, solution.findKthLargest(input, 2));
  }

  @Test
  public void testPartition() {
    final int[] input = new int[]{3, 2, 1, 5, 6, 4};
    int pivotIndex = solution.partition(input, 0, input.length - 1);
    System.out.println("pivotIndex = " + pivotIndex);
    System.out.println(Arrays.toString(input));
  }

}
