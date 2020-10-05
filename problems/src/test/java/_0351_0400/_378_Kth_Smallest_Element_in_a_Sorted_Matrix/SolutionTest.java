package _0351_0400._378_Kth_Smallest_Element_in_a_Sorted_Matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase() {
    final int[][] input = new int[][]{
        {1, 5, 9},
        {10, 11, 13},
        {12, 13, 15}
    };

    assertEquals(13, solution.kthSmallest(input, 8));
  }

}