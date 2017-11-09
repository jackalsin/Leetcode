package _351_400._378_Kth_Smallest_Element_in_a_Sorted_Matrix;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int[][] input = new int[][]{
        {1, 5, 9},
        {10, 11, 13},
        {12, 13, 15}
    };

    assertEquals(13, solution.kthSmallest(input, 8));
  }

}