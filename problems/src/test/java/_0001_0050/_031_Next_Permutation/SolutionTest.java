package _0001_0050._031_Next_Permutation;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


/**
 * @author jacka
 * @version 1.0 on 1/31/2017.
 */
class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(new Solution());
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithRegularElement(Solution solution) {
    final int[] input = new int[]{1, 4, 6, 5, 3, 2};
    solution.nextPermutation(input);
    final int[] result = new int[]{1, 5, 2, 3, 4, 6};
    assertArrayEquals(result, input);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithDuplicatedElement(Solution solution) {
    final int[] input = new int[]{1, 5, 1};
    solution.nextPermutation(input);
    final int[] result = new int[]{5, 1, 1};
    assertArrayEquals(result, input);
  }

}