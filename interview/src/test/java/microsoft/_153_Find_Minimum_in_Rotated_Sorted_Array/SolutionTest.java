package microsoft._153_Find_Minimum_in_Rotated_Sorted_Array;

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
  void testOneElement() {
    final int[] input = new int[]{1};
    assertEquals(1, solution.findMin(input));
  }

  @Test
  void testTwoElement() {
    final int[] input = new int[]{1, 2};
    assertEquals(1, solution.findMin(input));
  }

  @Test
  void testTwoElements() {
    final int[] input = new int[]{2, 1};
    assertEquals(1, solution.findMin(input));
  }

  @Test
  void test5Elements() {
    final int[] input = new int[]{2, 3, 4, 0, 1};
    assertEquals(0, solution.findMin(input));
  }


}