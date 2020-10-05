package linkedin.mianjing._034_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

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
  void testWithSingleIndex() {
    final int[] input = new int[]{1, 2, 3, 4, 5};
    assertArrayEquals(new int[]{2, 2}, solution.searchRange(input, 3));
  }

  @Test
  void testWithNotFoundSingleValue() {
    final int[] input = new int[]{1, 2, 3, 4, 5};
    assertArrayEquals(new int[]{-1, -1}, solution.searchRange(input, -1));
  }

  @Test
  void testWithDupFindValue() {
    final int[] input = new int[]{1, 2, 3, 3, 3, 4, 5};
    assertArrayEquals(new int[]{2, 4}, solution.searchRange(input, 3));
  }

  @Test
  void testWithSingleValueArrayOdd() {
    final int[] input = new int[]{1};
    assertArrayEquals(new int[]{0, 0}, solution.searchRange(input, 1));
  }

  @Test
  void testWithSingleValueArrayEven() {
    final int[] input = new int[]{2};
    assertArrayEquals(new int[]{0, 0}, solution.searchRange(input, 2));
  }

  @Test
  void testFailedCase1() {
    final int[] input = {5, 7, 7, 8, 8, 10};
    assertArrayEquals(new int[]{3, 4}, solution.searchRange(input, 8));
  }

  @Test
  void testFailedCase2() {
    final int[] input = {2, 2};
    assertArrayEquals(new int[]{-1, -1}, solution.searchRange(input, 3));
  }
}