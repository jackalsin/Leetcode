package _0001_0050._041_First_Missing_Positive;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/20/2017.
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testMissing1(Solution solution) {
    final int[] input = new int[]{0, -1, 3, 5, 2};
    assertEquals(1, solution.firstMissingPositive(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWith1ToN(Solution solution) {
    final int[] input = new int[]{1, 2, 3, 4};
    assertEquals(5, solution.firstMissingPositive(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new BucketSortSolution()
    );
  }
}