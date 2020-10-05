package linkedin._034_Search_for_a_Range;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 10/16/2017.
 */
class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    final int[] input = {2, 2};
    assertArrayEquals(new int[]{0, 1}, solution.searchRange(input, 2));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] input = {5, 7, 7, 8, 8, 10};
    assertArrayEquals(new int[]{3, 4}, solution.searchRange(input, 8));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase(Solution solution) {
    final int[] input = {1};
    assertArrayEquals(new int[]{0, 0}, solution.searchRange(input, 1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase2(Solution solution) {
    final int[] input = {5, 7, 7, 8, 8, 10};
    assertArrayEquals(new int[]{-1, -1}, solution.searchRange(input, 6));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV(),
        new SolutionV(),
        new SolutionVI()
    );
  }
}
