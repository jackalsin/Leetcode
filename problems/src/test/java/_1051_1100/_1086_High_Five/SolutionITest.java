package _1051_1100._1086_High_Five;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 6/27/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] items = {
        {1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77},
        {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}},
        expected = {{1, 87}, {2, 88}},
        actual = solution.highFive(items);
    assertTrue(Arrays.deepEquals(expected, actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}