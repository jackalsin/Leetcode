package _0701_0750._702_Search_in_a_Sorted_Array_of_Unknown_Size;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils._702_Search_in_a_Sorted_Array_of_Unknown_Size.ArrayReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final ArrayReader ar = new ArrayReader(new int[]{-1, 0, 3, 5, 9, 12});
    final int target = 9;
    assertEquals(4, solution.search(ar, target));
  }

  @Test
  void testOnlineCase2() {
    final ArrayReader ar = new ArrayReader(new int[]{-1, 0, 3, 5, 9, 12});
    final int target = 2;
    assertEquals(-1, solution.search(ar, target));
  }
}