package _0851_0900._890_Find_and_Replace_Pattern;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/20/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
    final String pattern = "abb";
    final List<String> expected = List.of("mee", "aqq"),
        actual = solution.findAndReplacePattern(words, pattern);
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    assertEquals(expected.size(), actual.size());
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final String[] words = {"badc", "abab", "dddd", "dede", "yyxx"};
    final String pattern = "baba";
    final List<String> expected = List.of("abab", "dede"),
        actual = solution.findAndReplacePattern(words, pattern);
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    assertEquals(expected.size(), actual.size());
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}