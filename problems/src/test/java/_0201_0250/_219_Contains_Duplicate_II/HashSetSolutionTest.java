package _0201_0250._219_Contains_Duplicate_II;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 8/14/2017.
 */
class HashSetSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new HashSetSolution();
  }

  @Test
  void testEmpty() throws Exception {
    assertFalse(solution.containsNearbyDuplicate(new int[]{}, 0));
  }


  @Test
  void testUnorderedArray() throws Exception {
    final int[] input = new int[]{1, 5, -3, 5, 2, 11, 7};
    assertTrue(solution.containsNearbyDuplicate(input, 4));
  }
}
