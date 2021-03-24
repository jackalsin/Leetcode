package byteDance._139_Word_Break;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 3/23/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testLeetCode(Solution solution) {
    final String input = "leetcode";
    List<String> dict = Arrays.asList("leet", "code");
    assertTrue(solution.wordBreak(input, dict));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testA(Solution solution) {
    final String input = "aaa";
    List<String> dict = Collections.singletonList("a");
    assertTrue(solution.wordBreak(input, dict));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}