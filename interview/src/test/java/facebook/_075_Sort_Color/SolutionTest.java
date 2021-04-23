package facebook._075_Sort_Color;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }

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
    final int[] input = new int[]{0, 0};
    final int[] expected = new int[]{0, 0};
    Arrays.sort(expected);
    solution.sortColors(input);
    assertArrayEquals(expected, input);
  }
}