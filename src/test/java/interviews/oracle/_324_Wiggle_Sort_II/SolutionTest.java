package interviews.oracle._324_Wiggle_Sort_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;
import static utils._324_Wiggle_Sort_II.Validator.assertIsWiggle;

/**
 * @author jacka
 * @version 1.0 on 12/1/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase(Solution solution) {
    final int[] input = {1, 2, 2, 1, 2, 1, 1, 1, 1, 2, 2, 2};
    solution.wiggleSort(input);
    assertTrue(assertIsWiggle(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase2(Solution solution) {
    final int[] input = {1};
    solution.wiggleSort(input);
    assertTrue(assertIsWiggle(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase3(Solution solution) {
    final int[] input = {4, 5, 5, 6};
    solution.wiggleSort(input);
//    System.out.println(Arrays.toString(input));
    assertTrue(assertIsWiggle(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase4(Solution solution) {
    final int[] input = {1, 3, 2, 2, 3, 1};
    solution.wiggleSort(input);
//    System.out.println(Arrays.toString(input));
    assertTrue(assertIsWiggle(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}