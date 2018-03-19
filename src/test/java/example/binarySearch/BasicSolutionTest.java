package example.binarySearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicSolutionTest {

  @Test
  public void testNormalCase() {
    final int[] nums = {1, 2, 3, 4, 5, 6, 7};
    final int target = 2;
    assertEquals(1, BasicSolution.equalTo(nums, target));
  }

  @Test
  public void testNormalCase2() {
    final int[] nums = {-1, 0, 3, 5, 9, 12};
    final int target = 9;
    assertEquals(4, BasicSolution.equalTo(nums, target));
  }


  @Test
  public void testOdd() {
    final int[] nums = {5};
    final int target = 5;
    assertEquals(0, BasicSolution.equalTo(nums, target));
  }
}
