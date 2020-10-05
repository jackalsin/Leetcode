package google._844_Backspace_String_Compare;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 4/13/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String S = "ab#c", T = "ad#c";
    assertTrue(solution.backspaceCompare(S, T));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String S = "a##c", T = "#a#c";
    assertTrue(solution.backspaceCompare(S, T));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String S = "a#c", T = "b";
    assertFalse(solution.backspaceCompare(S, T));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final String S = "ab##", T = "c#d#";
    assertTrue(solution.backspaceCompare(S, T));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final String S = "xywrrmp", T = "xywrrmu#p";
    assertTrue(solution.backspaceCompare(S, T));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase6(Solution solution) {
    final String S = "nzp#o#g", T = "b#nzp#o#g";
    assertTrue(solution.backspaceCompare(S, T));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase7(Solution solution) {
    final String S = "bxj##tw", T = "bxo#j##tw";
    assertTrue(solution.backspaceCompare(S, T));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase8(Solution solution) {
    final String S = "ab##", T = "c#d#";
    assertTrue(solution.backspaceCompare(S, T));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}