package example.binarySearch.problemSet._033_Search_in_Rotated_Sorted_Array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  private static final int[] LEFT_SORT = new int[] {4, 5, 6, 8, 10, 0, 1, 2};
  private static final int[] RIGHT_SORT = new int[] {6, 7, 9, 0, 1, 3, 4, 5};

  @Test
  void testWithLeftSortedTargetLeftFound() throws Exception {
    assertEquals(2, solution.search(LEFT_SORT, 6));
  }

  @Test
  void testWithLeftSortedTargetLeftNotFound() throws Exception {
    assertEquals(-1, solution.search(LEFT_SORT, 7));
  }

  @Test
  void testWithLeftSortedTargetRightFound() throws Exception {
    assertEquals(LEFT_SORT.length - 1, solution.search(LEFT_SORT, 2));
  }

  @Test
  void testWithLeftSortedTargetRightNotFound() throws Exception {
    assertEquals(-1, solution.search(LEFT_SORT, 11));
  }

  @Test
  void testWithLeftSortedTargetNotBetweenEnds() throws Exception {
    assertEquals(-1, solution.search(LEFT_SORT, 3));
  }

  // -------- right sorted ---------
  @Test
  void testWithRightSortedTargetLeftFound() throws Exception {
    assertEquals(1, solution.search(RIGHT_SORT, 7));
  }

  @Test
  void testWithRightSortedTargetLeftNotFound() throws Exception {
    assertEquals(-1, solution.search(RIGHT_SORT, 8));
  }

  @Test
  void testWithRightSortedTargetRightFound() throws Exception {
    assertEquals(5, solution.search(RIGHT_SORT, 3));
  }

  @Test
  void testWithRightSortedTargetRightNotFound() throws Exception {
    assertEquals(-1, solution.search(RIGHT_SORT, 8));
  }
}
