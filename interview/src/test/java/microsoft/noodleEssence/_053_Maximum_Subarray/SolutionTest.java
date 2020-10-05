package microsoft.noodleEssence._053_Maximum_Subarray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void maxSubArrayWithPositiveMore() {
    final int[] input = new int[]{4, 5, 3, -3, 2};
    assertEquals(12, solution.maxSubArray(input));
  }

  @Test
  void testWithOneElement() {
    final int[] input = new int[]{3};
    assertEquals(3, solution.maxSubArray(input));
  }

  @Test
  void testWithOneNegativeElement() {
    final int[] input = new int[]{-3};
    assertEquals(-3, solution.maxSubArray(input));
  }

  @Test
  void testWithTwoNegativeElement() {
    final int[] input = new int[]{-3, -2};
    assertEquals(-2, solution.maxSubArray(input));
  }

  @Test
  void testWithTwoNegativeElementReverse() {
    final int[] input = new int[]{-2, -3};
    assertEquals(-2, solution.maxSubArray(input));
  }

}