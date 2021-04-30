package google._833_Find_And_Replace_in_String;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/31/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String S = "abcd", sources[] = {"a", "cd"}, targets[] = {"eee", "ffff"}, expected = "eeebffff";
    final int[] indexes = {0, 2};
    assertEquals(expected, solution.findReplaceString(S, indexes, sources, targets));
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

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String S = "mhnbzxkwzxtaanmhtoirxheyanoplbvjrovzudznmetkkxrdmr";
    final int[] indexes = {46, 29, 2, 44, 31, 26, 42, 9, 38, 23, 36, 12, 16, 7, 33, 18};
    final String[] sources = {"rym", "kv", "nbzxu", "vx", "js", "tp", "tc", "jta", "zqm", "ya", "uz", "avm", "tz",
        "wn", "yv", "ird"}, targets = {"gfhc", "uq", "dntkw", "wql", "s", "dmp", "jqi", "fp", "hs", "aqz", "ix", "jag"
        , "n", "l", "y", "zww"};
    final String actual = solution.findReplaceString(S, indexes, sources, targets);
    assertEquals("mhnbzxkwzxtaanmhtoirxheaqznoplbvjrovzudznmetkkxrdmr", actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}