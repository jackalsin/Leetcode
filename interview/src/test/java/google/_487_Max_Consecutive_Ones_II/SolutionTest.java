package google._487_Max_Consecutive_Ones_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/21/2018.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] nums = {1, 0, 1, 1, 0};
    assertEquals(4, solution.findMaxConsecutiveOnes(nums));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] nums = {0};
    assertEquals(1, solution.findMaxConsecutiveOnes(nums));
  }
}
