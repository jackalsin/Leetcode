package _0651_0700._683_K_Empty_Slots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/31/2017.
 */
public class SolutionTest {

  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new NLogNSolution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] nums = {1, 3, 2};
    assertEquals(2, solution.kEmptySlots(nums, 1));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] nums = {1, 2, 3};
    assertEquals(-1, solution.kEmptySlots(nums, 1));
  }

}
