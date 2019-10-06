package interviews.pureStorage._0075_Sort_Colors;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 10/6/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[] input = new int[]{1, 2, 2, 1, 0, 2, 1, 2};
    final int[] expected = new int[]{1, 2, 2, 1, 0, 2, 1, 2};
    Arrays.sort(expected);
    solution.sortColors(input);
    assertArrayEquals(expected, input);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}