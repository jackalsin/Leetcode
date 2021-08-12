package _0651_0700._679_24_Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 12/30/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] nums = {4, 1, 8, 7};
    assertTrue(solution.judgePoint24(nums));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] nums = {1, 2, 1, 2};
    assertFalse(solution.judgePoint24(nums));
  }
}
