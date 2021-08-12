package airbnb._031_Next_Permutation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


/**
 * @author jacka
 * @version 1.0 on 1/21/2019.
 */
class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[] input = {1, 1}, expected = {1, 1};
    solution.nextPermutation(input);
    assertArrayEquals(expected, input);
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