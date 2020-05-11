package _0651_0700._693_Binary_Number_with_Alternating_Bits;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 3/15/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    assertTrue(solution.hasAlternatingBits(5));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase10(Solution solution) {
    assertTrue(solution.hasAlternatingBits(10));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase11(Solution solution) {
    assertFalse(solution.hasAlternatingBits(11));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase7(Solution solution) {
    assertFalse(solution.hasAlternatingBits(7));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}