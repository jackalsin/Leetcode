package interviews.linkedin._033_Search_in_Rotated_Sorted_Array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIVTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new SolutionIV();
  }

  @Test
  void testFailedCase1() throws Exception {
    final int[] input = {1, 3, 5};
    assertEquals(-1, solution.search(input, 0));
  }

  @Test
  void testFailedCase4() throws Exception {
    final int[] input = {4, 5, 6, 7, 0, 1, 2};
    assertEquals(4, solution.search(input, 0));
  }

  @Test
  void testFailedCase2() throws Exception {
    final int[] input = {1, 3};
    assertEquals(1, solution.search(input, 3));
  }

  @Test
  void testFailedCase3() throws Exception {
    final int[] input = {3, 1};
    assertEquals(1, solution.search(input, 1));
  }

  @Test
  void testFailedOnEmpty() throws Exception {
    final int[] input = {};
    assertEquals(-1, solution.search(input, 3));
  }
}