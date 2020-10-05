package linkedin._127_Word_Ladder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 10/20/2017.
 */
class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedOnNonExistence(Solution solution) {
    final List<String> wordList = List.of("hot", "dot", "dog", "lot", "log");
    final String begin = "hit";
    final String end = "cog";
    assertEquals(0, solution.ladderLength(begin, end, wordList));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCount(Solution solution) {
//    Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog"
    final List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
    final String begin = "hit";
    final String end = "cog";
    assertEquals(5, solution.ladderLength(begin, end, wordList));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testBeginWordCount(Solution solution) {
    final List<String> wordList = List.of("a", "b", "c");
    final String begin = "a";
    final String end = "c";
    assertEquals(2, solution.ladderLength(begin, end, wordList));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SingleBfsSolution(),
        new BiDirectionBfsSolution()
    );
  }

}
