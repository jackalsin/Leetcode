package interviews.linkedin._033_Search_in_Rotated_Sorted_Array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/16/2017.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase1(Solution solution) {
    final int[] intput = {1, 3, 5};
    assertEquals(-1, solution.search(intput, 0));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase2(Solution solution) {
    final int[] input = {1, 3};
    assertEquals(1, solution.search(input, 3));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase3(Solution solution) {
    final int[] input = {3, 1};
    assertEquals(1, solution.search(input, 1));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedOnEmpty(Solution solution) {
    final int[] input = {};
    assertEquals(-1, solution.search(input, 3));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV(),
        new SolutionV(),
        new SolutionVI(),
        new SolutionVII()
    );
  }
}
