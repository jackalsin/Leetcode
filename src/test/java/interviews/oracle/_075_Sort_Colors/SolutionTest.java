package interviews.oracle._075_Sort_Colors;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 10/29/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test1(Solution solution) {
    final int[] input = new int[]{1, 2, 2, 1, 0, 2, 1, 2};
    final int[] expected = new int[]{1, 2, 2, 1, 0, 2, 1, 2};
    Arrays.sort(expected);
    solution.sortColors(input);
    assertArrayEquals(expected, input);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test2(Solution solution) {
    final int[] input = new int[]{2, 0, 2, 1, 1, 0},
        expected = new int[]{0, 0, 1, 1, 2, 2};
    Arrays.sort(expected);
    solution.sortColors(input);
    assertArrayEquals(expected, input);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}