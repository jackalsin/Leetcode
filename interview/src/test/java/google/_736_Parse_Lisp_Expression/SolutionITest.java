package google._736_Parse_Lisp_Expression;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/19/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String input = "(add 1 2)";
    assertEquals(3, solution.evaluate(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String input = "(mult 3 (add 2 3))";
    assertEquals(15, solution.evaluate(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String input = "(let x 2 (mult x 5))";
    assertEquals(10, solution.evaluate(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final String input = "(let x 2 (mult x (let x 3 y 4 (add x y))))";
    assertEquals(14, solution.evaluate(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final String input = "(let x 3 x 2 x)";
    assertEquals(2, solution.evaluate(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase6(Solution solution) {
    final String input = "(let x 1 y 2 x (add x y) (add x y))";
    assertEquals(5, solution.evaluate(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase7(Solution solution) {
    final String input = "(let x 2 (add (let x 3 (let x 4 x)) x))";
    assertEquals(6, solution.evaluate(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase8(Solution solution) {
    final String input = "(let a1 3 b2 (add a1 1) b2)";
    assertEquals(4, solution.evaluate(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase9(Solution solution) {
    final String input = "(let x -2 y x y)";
    assertEquals(-2, solution.evaluate(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase10(Solution solution) {
    final String input = "(let x 7 -12)";
    assertEquals(-12, solution.evaluate(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}