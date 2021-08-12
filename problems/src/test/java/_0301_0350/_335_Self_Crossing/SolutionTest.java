package _0301_0350._335_Self_Crossing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 10/3/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] input = {2, 1, 1, 2};
    assertTrue(solution.isSelfCrossing(input));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] input = {1, 2, 3, 4};
    assertFalse(solution.isSelfCrossing(input));
  }

  @Test
  public void testOnlineCase3() throws Exception {
    final int[] input = {1, 1, 1, 1};
    assertTrue(solution.isSelfCrossing(input));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final int[] input = {3, 3, 3, 2, 1, 1};
    assertFalse(solution.isSelfCrossing(input));
  }

}
