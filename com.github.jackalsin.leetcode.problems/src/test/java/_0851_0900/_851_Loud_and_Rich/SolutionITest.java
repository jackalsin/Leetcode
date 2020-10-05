package _0851_0900._851_Loud_and_Rich;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 9/6/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int richer[][] = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}},
        quiet[] = {3, 2, 5, 4, 6, 1, 7, 0},
        expected[] = {5, 5, 2, 5, 4, 5, 6, 7},
        actual[] = solution.loudAndRich(richer, quiet);
    assertArrayEquals(expected, actual, "actual = " + Arrays.toString(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}