package _0251_0300._280_Wiggle_Sort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static utils._280_Wiggle_Sort.Validator.assertIsWiggle;

/**
 * @author jacka
 * @version 1.0 on 2/24/2019.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] input = {3, 5, 2, 1, 6, 4};
    solution.wiggleSort(input);
    assertIsWiggle(input);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(new Solution());
  }
}