package interviews.linkedin._152_Maximum_Product_Subarray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/5/18
 */
class SolutionIVTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionIV();
  }

  @Test
  void testOnline() {
    final int[] input = new int[]{2, 3, -2, 4};
    assertEquals(6, solution.maxProduct(input));
  }

  @Test
  void testOnline2() {
    final int[] input = new int[]{-4, -3, -2};
    assertEquals(12, solution.maxProduct(input));
  }

}