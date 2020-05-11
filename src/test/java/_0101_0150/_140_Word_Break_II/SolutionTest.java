package _0101_0150._140_Word_Break_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/8/2017.
 */
public class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testLeetCode(Solution solution) {
    List<String> candidates = Arrays.asList("leet", "code");
    final String input = "leetcode";
    assertEquals(Arrays.asList("leet code"), solution.wordBreak(input, candidates));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCaseMle(Solution solution) {
    List<String> candidates = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa",
        "aaaaaaaaa", "aaaaaaaaaa");
    final String input =
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    assertEquals(Arrays.asList(), solution.wordBreak(input, candidates));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
//        new DpSolution(), // failed on MLE
        new MemorizedSolution());
  }
}
