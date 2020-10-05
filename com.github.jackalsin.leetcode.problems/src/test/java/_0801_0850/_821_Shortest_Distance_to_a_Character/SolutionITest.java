package _0801_0850._821_Shortest_Distance_to_a_Character;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 9/1/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String s = "loveleetcode";
    final char c = 'e';
    final int[] expected = {
        3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0
    }, actual = solution.shortestToChar(s, c);
    assertArrayEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}