package _1151_1200._1170_Compare_Strings_by_Frequency_of_the_Smallest_Character;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 10/20/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String[] queries = {"cbd"}, words = {"zaaaz"};
    final int[] expected = {1},
        actual = solution.numSmallerByFrequency(queries, words);
    assertArrayEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final String[] queries = {"bbb", "cc"}, words = {"a", "aa", "aaa", "aaaa"};
    final int[] expected = {1, 2},
        actual = solution.numSmallerByFrequency(queries, words);
    assertArrayEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}