package google._768_Max_Chunks_To_Make_Sorted_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/26/2018.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
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

  @Test
  public void testFailedCase1() throws Exception {
    final int[] nums = {5, 4, 3, 2, 1};
    assertEquals(1, solution.maxChunksToSorted(nums));
  }

  @Test
  public void testFailedCase2() throws Exception {
    final int[] nums = {2, 1, 3, 4, 4};
    assertEquals(4, solution.maxChunksToSorted(nums));
  }
}
