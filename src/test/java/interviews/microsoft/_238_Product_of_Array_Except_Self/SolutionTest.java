package interviews.microsoft._238_Product_of_Array_Except_Self;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase() {
    final int[] input = new int[]{1, 2, 3, 4};
    final int[] expected = new int[]{24, 12, 8, 6};
    assertArrayEquals(expected, solution.productExceptSelf(input));
  }
}