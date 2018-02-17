package interviews.uber._139_Word_Break;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
}