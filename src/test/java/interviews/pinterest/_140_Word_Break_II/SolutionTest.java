package interviews.pinterest._140_Word_Break_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
    List<String> candidates = Arrays.asList("leet", "code");
    final String input = "leetcode";
    assertEquals(Arrays.asList("leet code"), solution.wordBreak(input, candidates));
  }

  @Test
  void testFailedCase1() {
    List<String> candidates = Arrays.asList("a", "abc", "b", "cd");
    final String input = "abcd";
    assertEquals(Arrays.asList("a b cd"), solution.wordBreak(input, candidates));
  }
}