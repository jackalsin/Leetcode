package _0751_0800._777_Swap_Adjacent_in_LR_String;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 3/6/2018.
 */
class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(new Solution());
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String start = "RXXLRXRXL", end = "XRLXXRRLX";
    assertTrue(solution.canTransform(start, end));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase(Solution solution) {
    final String start = "XXRXXLXXXX",
        end = "XXXXRXXLXX";
    assertFalse(solution.canTransform(start, end));
  }
}
