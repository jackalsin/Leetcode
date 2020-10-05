package oracle.randomNextWord;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/8/2019
 */
class SolutionITest {
  private static final double BIAS = 1e-3;

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    solution.addWord("hello");
    solution.addWord("alice");
    solution.addWord("hello");
    solution.addWord("bob");
    solution.addWord("hello");
    final int max = 10_000_000;
    final Map<String, Integer> wordCount = new HashMap<>();
    for (int i = 0; i < max; ++i) {
      final String word = solution.getWord("hello");
      wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
    }
    final double expected = (double) 1 / 2;
    for (final Map.Entry<String, Integer> e : wordCount.entrySet()) {
      final double actual = (double) e.getValue() / max;
      assertEquals(expected, actual, BIAS);
    }
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new HashMapSolution(),
        new TrieSolution()
    );
  }
}