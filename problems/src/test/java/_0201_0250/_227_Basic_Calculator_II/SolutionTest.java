package _0201_0250._227_Basic_Calculator_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author jacka
 * @version 1.0 on 8/17/2017.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnline1(Solution solution) {
    final String input = "3+2*2";
    assertEquals(7, solution.calculate(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnline2(Solution solution) {
    final String input = " 3/2 ";
    assertEquals(1, solution.calculate(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnline3(Solution solution) {
    final String input = " 3+5 / 2 ";
    assertEquals(5, solution.calculate(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(new GenericSolution());
  }
}
