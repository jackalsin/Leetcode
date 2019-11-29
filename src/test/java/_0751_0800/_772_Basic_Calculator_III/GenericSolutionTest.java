package _0751_0800._772_Basic_Calculator_III;

import _0201_0250._227_Basic_Calculator_II.GenericSolution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericSolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String input = "1 + 1";
    assertEquals(2, solution.calculate(input)); // = 2
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final String input = " 6-4 / 2 ";
    assertEquals(4, solution.calculate(input)); // = 2
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final String input = "2*(5+5*2)/3+(6/2+8)";
    assertEquals(21, solution.calculate(input)); // = 2
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final String input = "(2+6* 3+5- (3*14/7+2)*5)+3";
    assertEquals(-12, solution.calculate(input)); // = 2
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(new GenericStackSolution(), new GenericRecursionSolution());
  }
}
