package interviews.linkedin._833_Find_And_Replace_in_String;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String S = "abcd";
    final int[] indexes = {0, 2};
    final String[] sources = {"a", "cd"}, targets = {"eee", "ffff"};
    final String actual = solution.findReplaceString(S, indexes, sources, targets);
    assertEquals("eeebffff", actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String S = "abcd";
    final int[] indexes = {0, 2};
    final String[] sources = {"ab", "ec"}, targets = {"eee", "ffff"};
    final String actual = solution.findReplaceString(S, indexes, sources, targets);
    assertEquals("eeecd", actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII()
    );
  }
}