package _0101_0150._127_Word_Ladder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/29/2017.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    final String beginWord = "hit";
    final String endWord = "cog";
    List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
    assertEquals(5, solution.ladderLength(beginWord, endWord, wordList));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String beginWord = "hit";
    final String endWord = "cog";
    List<String> wordList = List.of("hot", "dot", "dog", "lot", "log");
    assertEquals(0, solution.ladderLength(beginWord, endWord, wordList));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new BfsSolution(),
        new BidirectionBfsSolution()
    );
  }
}
