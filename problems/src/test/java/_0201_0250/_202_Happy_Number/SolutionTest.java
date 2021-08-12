package _0201_0250._202_Happy_Number;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 8/5/2017.
 */
class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(new SolutionI(), new SolutionII());
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testIsHappy(Solution solution) {
    assertTrue(solution.isHappy(19));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test887(Solution solution) {
    assertFalse(solution.isHappy(887));
  }

}
