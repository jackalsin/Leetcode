package _0951_1000._957_Prison_Cells_After_N_Days;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 9/29/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int cells[] = {0, 1, 0, 1, 1, 0, 0, 1}, N = 7, expected[] = {0, 0, 1, 1, 0, 0, 0, 0},
        actual[] = solution.prisonAfterNDays(cells, N);
    assertArrayEquals(expected, actual, "actual = " + Arrays.toString(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int cells[] = {1, 0, 0, 1, 0, 0, 1, 0}, N = 1_000_000_000, expected[] = {0, 0, 1, 1, 1, 1, 1, 0},
        actual[] = solution.prisonAfterNDays(cells, N);
    assertArrayEquals(expected, actual, "actual = " + Arrays.toString(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}