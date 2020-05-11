package interviews.uber._140_Word_Break_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testLeetCode(Solution solution) {
    List<String> candidates = List.of("leet", "code");
    final String input = "leetcode";
    assertEquals(List.of("leet code"), solution.wordBreak(input, candidates));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmpty(Solution solution) {
    List<String> candidates = List.of();
    final String input = "";
    final List<String> actual = solution.wordBreak(input, candidates);
    assertEquals(new ArrayList<>(), actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase1(Solution solution) {
    final List<String> candidates = List.of("cat", "cats", "and", "sand", "dog");
    final String input = "catsanddog";
    final List<String> actual = solution.wordBreak(input, candidates);
    final List<String> expected = List.of("cats and dog", "cat sand dog");
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testTLECase1(Solution solution) {
    final List<String> wordList = List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa",
        "aaaaaaaaa", "aaaaaaaaaa");
    final String input =
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    final long startTime = System.nanoTime();
    final List<String> actual = solution.wordBreak(input, wordList);
    final long endTime = System.nanoTime();

    System.out.println((endTime - startTime) / 1E6 + " ms");
//    final List<String> expected =
//        assertEquals();
  }
}