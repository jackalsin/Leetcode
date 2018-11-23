package _0001_0050._031_Next_Permutation;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 1/31/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testWithRegularElement() throws Exception {
    final int[] input = new int[]{1, 4, 6, 5, 3, 2};
    solution.nextPermutation(input);
    final int[] result = new int[]{1, 5, 2, 3, 4, 6};
    assertArrayEquals(result, input);
  }

  @Test
  void testWithDuplicatedElement() throws Exception {
    final int[] input = new int[]{1, 5, 1};
    solution.nextPermutation(input);
    final int[] result = new int[]{5, 1, 1};
    assertArrayEquals(result, input);
  }

}