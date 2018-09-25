package interviews.linkedin._033_Search_in_Rotated_Sorted_Array;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/16/2017.
 */
class SolutionIIITest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new SolutionIII();
  }

  @Test
  void testFailedCase1() throws Exception {
    final int[] intput = {1, 3, 5};
    assertEquals(-1, solution.search(intput, 0));
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
