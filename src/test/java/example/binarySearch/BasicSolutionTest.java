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
}