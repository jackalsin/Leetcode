package _0951_1000._954_Array_of_Doubled_Pairs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 9/28/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    assertFalse(solution.canReorderDoubled(new int[]{3, 1, 3, 6}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    assertFalse(solution.canReorderDoubled(new int[]{2, 1, 2, 6}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    assertTrue(solution.canReorderDoubled(new int[]{4, -2, 2, -4}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    assertFalse(solution.canReorderDoubled(new int[]{1, 2, 4, 16, 8, 4}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    assertFalse(solution.canReorderDoubled(new int[]{-4, -6, -1, -2, -1, -1, -3, -8}));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}