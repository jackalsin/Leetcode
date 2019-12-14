package _0101_0150._139_Word_Break;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 7/5/2017.
 */
class SolutionTest {

  @Test
  void testLeetCode(Solution solution) {
    final String input = "leetcode";
    List<String> dict = Arrays.asList("leet", "code");
    assertTrue(solution.wordBreak(input, dict));
  }

  @Test
  void testA(Solution solution) {
    final String input = "aaa";
    List<String> dict = Collections.singletonList("a");
    assertTrue(solution.wordBreak(input, dict));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(new Solution());
  }
}
