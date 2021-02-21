package apple.maxNumberToken;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/20/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String line = "the quick brown fox jumps over the lazy dog";
    final Map<String, Integer> expected = Map.of(
        "the", 2,
        "quick", 1,
        "brown", 1,
        "fox", 1,
        "jumps", 1,
        "over", 1, "lazy", 1, "dog", 1
    ), actual = solution.getMaxNumberToken(line, 1);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String line = "the quick brown fox jumps over the lazy dog";
    final Map<String, Integer> expected = Map.ofEntries(
        entry("the", 2), entry("quick", 1), entry("brown", 1),
        entry("fox", 1), entry("jumps", 1), entry("over", 1), entry("lazy", 1),
        entry("dog", 1), entry("the quick", 1), entry("quick brown", 1),
        entry("brown fox", 1), entry("fox jumps", 1),
        entry("jumps over", 1), entry("over the", 1),
        entry("the lazy", 1), entry("lazy dog", 1)
    ), actual = solution.getMaxNumberToken(line, 2);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}