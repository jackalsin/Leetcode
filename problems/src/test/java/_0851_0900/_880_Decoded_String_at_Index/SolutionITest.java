package _0851_0900._880_Decoded_String_at_Index;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/14/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String S = "leet2code3";
    final int K = 10;
    assertEquals("o", solution.decodeAtIndex(S, K));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String S = "ha22";
    final int K = 5;
    assertEquals("h", solution.decodeAtIndex(S, K));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String S = "a2345678999999999999999";
    final int K = 1;
    assertEquals("a", solution.decodeAtIndex(S, K));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}