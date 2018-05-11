package interviews.pinterest._139_Word_Break;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testLeetCode() {
    final String input = "leetcode";
    List<String> dict = Arrays.asList("leet", "code");
    assertTrue(solution.wordBreak(input, dict));
  }

  @Test
  void testA() {
    final String input = "aaa";
    List<String> dict = Collections.singletonList("a");
    assertTrue(solution.wordBreak(input, dict));
  }

  @Test
  void testFailedCase1() {
    final String input = "catsandog";
    List<String> dict = List.of("cats", "dog", "sand", "and", "cat");
    assertFalse(solution.wordBreak(input, dict));
  }

  @Test
  void testFailedCase2() {
    final String input = "a";
    List<String> dict = List.of();
    assertFalse(solution.wordBreak(input, dict));
  }

  @Test
  void testTLE() {
    final String input = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
    List<String> dict = List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
    assertFalse(solution.wordBreak(input, dict));
  }
}