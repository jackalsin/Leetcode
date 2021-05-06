package google._792_Number_of_Matching_Subsequences;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/3/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String S = "abcde";
    final String[] words = {"a", "bb", "acd", "ace"};
    assertEquals(3, solution.numMatchingSubseq(S, words));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String S = "dsahjpjauf";
    final String[] words = {"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"};
    assertEquals(2, solution.numMatchingSubseq(S, words));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new MapSolution()
    );
  }
}