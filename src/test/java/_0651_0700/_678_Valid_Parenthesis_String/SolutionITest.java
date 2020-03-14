package _0651_0700._678_Valid_Parenthesis_String;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 3/14/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    assertTrue(solution.checkValidString("()"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    assertTrue(solution.checkValidString("(*)"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    assertTrue(solution.checkValidString("(*))"));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new DfsSolution(),
        new StackSolution()
    );
  }
}