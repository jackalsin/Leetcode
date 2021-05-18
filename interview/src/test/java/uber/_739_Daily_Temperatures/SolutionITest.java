package uber._739_Daily_Temperatures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 5/17/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
    final int[] expected = {1, 1, 4, 2, 1, 1, 0, 0},
        actual = solution.dailyTemperatures(temp);
    assertArrayEquals(expected, actual, "actual = " + Arrays.toString(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}