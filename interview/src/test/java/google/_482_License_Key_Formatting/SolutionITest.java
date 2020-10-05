package google._482_License_Key_Formatting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/13/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String S = "5F3Z-2e-9-w";
    final int K = 4;
    assertEquals("5F3Z-2E9W", solution.licenseKeyFormatting(S, K));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String S = "2-5g-3-J";
    final int K = 2;
    assertEquals("2-5G-3J", solution.licenseKeyFormatting(S, K));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String S = "--a-a-a-a--";
    final int K = 2;
    assertEquals("AA-AA", solution.licenseKeyFormatting(S, K));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}