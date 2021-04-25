package google._616_Add_Bold_Tag_in_String;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/24/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase1(Solution solution) {
    final String s = "abcxyz123", expected = "<b>abc</b>xyz<b>123</b>";
    final String[] dict = {"abc", "123"};
    assertEquals(expected, solution.addBoldTag(s, dict));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase2(Solution solution) {
    final String s = "aaabbcc", expected = "<b>aaabbc</b>c";
    final String[] dict = {"aaa", "aab", "bc"};
    assertEquals(expected, solution.addBoldTag(s, dict));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailedCase1(Solution solution) {
    final String s = "aaabbcc", expected = "aaabbcc";
    final String[] dict = {};
    assertEquals(expected, solution.addBoldTag(s, dict));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new BooleanArraySolution(),
        new TrieSolution()
    );
  }
}