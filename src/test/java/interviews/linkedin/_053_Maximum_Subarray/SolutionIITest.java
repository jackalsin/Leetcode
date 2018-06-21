package interviews.linkedin._053_Maximum_Subarray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIITest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new SolutionII();
  }

  @Test
  void maxSubArrayWithPositiveMore() throws Exception {
    final int[] input = new int[]{4, 5, 3, -3, 2};
    assertEquals(12, solution.maxSubArray(input));
  }

  @Test
  void testWithOneElement() throws Exception {
    final int[] input = new int[]{3};
    assertEquals(3, solution.maxSubArray(input));
  }

  @Test
  void testWithOneNegativeElement() throws Exception {
    final int[] input = new int[]{-3};
    assertEquals(-3, solution.maxSubArray(input));
  }

  @Test
  void testWithTwoNegativeElement() throws Exception {
    final int[] input = new int[]{-3, -2};
    assertEquals(-2, solution.maxSubArray(input));
  }

  @Test
  void testWithTwoNegativeElementReverse() throws Exception {
    final int[] input = new int[]{-2, -3};
    assertEquals(-2, solution.maxSubArray(input));
  }

}