package interviews.google._215_Kth_Largest_Element_in_an_Array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/31/2018.
 */
public class SolutionTest {

  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOneElement() throws Exception {
    final int[] input = new int[] {1};
    assertEquals(1, solution.findKthLargest(input, 1));
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int[] input = new int[] {3, 2, 1, 5, 6, 4};
    assertEquals(5, solution.findKthLargest(input, 2));
  }

  @Test
  public void testDuplicate() throws Exception {
    final int[] input = new int[] {1, 2, 3, 4, 5, 5, 5, 6};
    assertEquals(5, solution.findKthLargest(input, 2));
    assertEquals(4, solution.findKthLargest(input, 5));
  }

}
