package _0451_0500._494_Target_Sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DfsSolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new DfsWrongSolution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] nums = {1, 1, 1, 1, 1};
    assertThrows(java.lang.AssertionError.class, () -> assertEquals(5, solution.findTargetSumWays(nums, 3)));
  }
}