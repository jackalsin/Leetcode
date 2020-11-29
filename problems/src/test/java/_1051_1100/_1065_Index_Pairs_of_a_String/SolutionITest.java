package _1051_1100._1065_Index_Pairs_of_a_String;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author zhixi
 * @version 1.0 on 11/29/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String text = "thestoryofleetcodeandme", words[] = {"story", "fleet", "leetcode"};
    final int[][] actual = solution.indexPairs(text, words),
        expected = {{3, 7}, {9, 13}, {10, 17}};
    assertArrayEquals(expected, actual, "actual = " + Arrays.deepToString(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final String text = "ababa", words[] = {"aba", "ab"};
    final int[][] actual = solution.indexPairs(text, words),
        expected = {{0, 1}, {0, 2}, {2, 3}, {2, 4}};
    assertArrayEquals(expected, actual, "actual = " + Arrays.deepToString(actual));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}