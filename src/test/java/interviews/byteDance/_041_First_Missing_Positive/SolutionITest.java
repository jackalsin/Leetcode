package interviews.byteDance._041_First_Missing_Positive;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/5/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testMissing1(Solution solution) {
    final int[] input = new int[]{0, -1, 3, 5, 2};
    assertEquals(1, solution.firstMissingPositive(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testMissing2(Solution solution) {
    final int[] input = new int[]{3, 4, -1, 1};
    assertEquals(2, solution.firstMissingPositive(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWith1ToN(Solution solution) {
    final int[] input = new int[]{1, 2, 3, 4};
    assertEquals(5, solution.firstMissingPositive(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}