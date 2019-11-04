package interviews.oracle._032_Longest_Valid_Parentheses;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/3/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithAllValid(Solution solution) {
    assertEquals(8, solution.longestValidParentheses("(()()())"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithLeadingValid(Solution solution) {
    assertEquals(8, solution.longestValidParentheses("(()()()()"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithTailingValid(Solution solution) {
    assertEquals(8, solution.longestValidParentheses("()()()())"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithAllInvalid(Solution solution) {
    assertEquals(0, solution.longestValidParentheses(")("));
  }
  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testPrevMatchThenTailMatch(Solution solution) {
    assertEquals(6, solution.longestValidParentheses("()(())"));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new StackSolution(),
        new DpSolution()
    );
  }
}