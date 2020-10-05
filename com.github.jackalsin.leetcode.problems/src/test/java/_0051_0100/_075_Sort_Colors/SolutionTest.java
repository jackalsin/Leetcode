package _0051_0100._075_Sort_Colors;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 5/11/2017.
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

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

}