package google._769_Max_Chunks_To_Make_Sorted;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/25/2018.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] nums = {4, 3, 2, 1, 0};
    assertEquals(1, solution.maxChunksToSorted(nums));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] nums = {1, 0, 2, 3, 4};
    assertEquals(4, solution.maxChunksToSorted(nums));
  }
}
