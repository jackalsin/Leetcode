package _0901_0950._942_DI_String_Match;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 9/26/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String s = "IDID";
    final int[] actual = solution.diStringMatch(s);
    assertPass(actual, s);
  }

  private void assertPass(final int[] vals, final String s) {
    for (int i = 0; i < s.length(); ++i) {
      final char chr = s.charAt(i);
      if (chr == 'I') {
        assertTrue(vals[i] < vals[i + 1], "Expecting increasing but vals[i] = "
            + vals[i] + ", vals[i + 1] = " + vals[i + 1]);
      } else {
        assertTrue(vals[i] > vals[i + 1], "Expecting decreasing but vals[i] = "
            + vals[i] + ", vals[i + 1] = " + vals[i + 1]);
      }
    }
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}