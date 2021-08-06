package linkedin._020_Valid_Parentheses;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionIIITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmptyString(Solution solution) {
    assertTrue(solution.isValid(""));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testIsValid1(Solution solution) {
    assertTrue(solution.isValid("()"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testIsValid2(Solution solution) {
    assertTrue(solution.isValid("()[]"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testIsValid3(Solution solution) {
    assertTrue(solution.isValid("()[]{}"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testIsValid4(Solution solution) {
    assertTrue(solution.isValid("([]{})"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testIsValid5(Solution solution) {
    assertFalse(solution.isValid("([)]"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testIsValid6(Solution solution) {
    assertFalse(solution.isValid("{(})"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testIsValid7(Solution solution) {
    assertFalse(solution.isValid("["));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII()
    );
  }
}
