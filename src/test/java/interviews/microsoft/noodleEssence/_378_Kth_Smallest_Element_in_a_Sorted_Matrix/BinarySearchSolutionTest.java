package interviews.microsoft.noodleEssence._378_Kth_Smallest_Element_in_a_Sorted_Matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new BinarySearchSolution();
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

  @Test
  void testOnlineCase2() {
    final int[][] input = new int[][]{
        {1, 2},
        {3, 3}
    };

    assertEquals(3, solution.kthSmallest(input, 3));

  }
}
