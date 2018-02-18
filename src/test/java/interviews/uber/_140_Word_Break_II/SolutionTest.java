package interviews.uber._140_Word_Break_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testLeetCode() {
    List<String> candidates = List.of("leet", "code");
    final String input = "leetcode";
    assertEquals(List.of("leet code"), solution.wordBreak(input, candidates));
  }

  @Test
  void testEmpty() {
    List<String> candidates = List.of();
    final String input = "";
    final List<String> actual = solution.wordBreak(input, candidates);
    assertEquals(new ArrayList<>(), actual);
  }

  @Test
  void testFailedCase1() {
    final List<String> candidates = List.of("cat", "cats", "and", "sand", "dog");
    final String input = "catsanddog";
    final List<String> actual = solution.wordBreak(input, candidates);
    final List<String> expected = List.of("cats and dog", "cat sand dog");
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @Test
  void testTLECase1() {
    final List<String> wordList = List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
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