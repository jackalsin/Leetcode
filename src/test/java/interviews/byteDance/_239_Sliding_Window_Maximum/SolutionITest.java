package interviews.byteDance._239_Sliding_Window_Maximum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jacka
 * @version 1.0 on 5/8/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOnline(Solution solution) {
    final int[] input = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
    final int[] expected = new int[]{3, 3, 5, 5, 6, 7};
    assertArrayEquals(expected, solution.maxSlidingWindow(input, 3));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testEmpty(Solution solution) {
    final int[] input = new int[]{};
    final int[] expected = new int[]{};
    assertArrayEquals(expected, solution.maxSlidingWindow(input, 0));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testFailedCase(Solution solution) {
    final int[] input = new int[]{-7, -8, 7, 5, 7, 1, 6, 0};
    final int[] expected = new int[]{7, 7, 7, 7, 7};
    assertArrayEquals(expected, solution.maxSlidingWindow(input, 4));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testFailedCase2(Solution solution) {
    final int[] input = new int[]{1, 3, 1, 2, 0, 5};
    final int[] expected = new int[]{3, 3, 2, 5};
    assertArrayEquals(expected, solution.maxSlidingWindow(input, 3));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}