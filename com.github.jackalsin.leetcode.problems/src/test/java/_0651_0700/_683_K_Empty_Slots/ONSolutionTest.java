package _0651_0700._683_K_Empty_Slots;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/31/2017.
 */
public class ONSolutionTest {

  private Solution solution;

  @Before
  public void setUp() throws Exception {
//    solution = new ONSolution();
    solution = new MyONSolution();
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

  @Test
  public void testOnlineCase3() throws Exception {
    final int[] nums = {1, 7, 4, 5, 6, 2, 3};
    assertEquals(4, solution.kEmptySlots(nums, 1));
  }

}
