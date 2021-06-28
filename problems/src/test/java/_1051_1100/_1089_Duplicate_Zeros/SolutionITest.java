package _1051_1100._1089_Duplicate_Zeros;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 6/27/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    //                   0, 1, 2, 3, 4, 5, 6, 7
    final int[] input = {1, 0, 2, 3, 0, 4, 5, 0},
        expected = {1, 0, 0, 2, 3, 0, 0, 4};
    solution.duplicateZeros(input);
    assertArrayEquals(expected, input, Arrays.toString(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] input = {1, 2, 3},
        expected = {1, 2, 3};
    solution.duplicateZeros(input);
    assertArrayEquals(expected, input, Arrays.toString(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[] input = {8, 4, 5, 0, 0, 0, 0, 7},
        expected = {8, 4, 5, 0, 0, 0, 0, 0};
    solution.duplicateZeros(input);
    assertArrayEquals(expected, input, Arrays.toString(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}