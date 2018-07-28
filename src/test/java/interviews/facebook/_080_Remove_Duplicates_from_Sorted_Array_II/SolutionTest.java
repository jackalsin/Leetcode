package interviews.facebook._080_Remove_Duplicates_from_Sorted_Array_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private int[] array1;

  private Solution solution;


  @BeforeEach
  void setUp() {
    array1 = new int[]{1, 1, 1, 2, 2, 3, 4};
    solution = new Solution();
  }

  @Test
  void testOnlineCase() {
    int size = solution.removeDuplicates(array1);
    final int[] expected = new int[]{1, 1, 2, 2, 3, 4};
    for (int i = 0; i < expected.length; i++) {
      assertEquals(expected[i], array1[i]);
    }
  }
}