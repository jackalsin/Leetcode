package oracle._772_Basic_Calculator_III;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhixi
 * @version 1.0 on 11/28/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String input = "1 + 1";
    assertEquals(2, solution.calculate(input)); // = 2
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String input = " 6-4 / 2 ";
    assertEquals(4, solution.calculate(input)); // = 2
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String input = "2*(5+5*2)/3+(6/2+8)";
    assertEquals(21, solution.calculate(input)); // = 2
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final String input = "(2+6* 3+5- (3*14/7+2)*5)+3";
    assertEquals(-12, solution.calculate(input)); // = 2
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final String input = "10/2/5";
    assertEquals(1, solution.calculate(input)); // = 2
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase6(Solution solution) {
    final String input = "-1+4*3/3/3";
    assertEquals(0, solution.calculate(input)); // = 2
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase7(Solution solution) {
    final String input = "(-1)+4*3/3/3";
    assertEquals(0, solution.calculate(input)); // = 2
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase8(Solution solution) {
    final String input = " (-1)+4*3/3/3";
    assertEquals(0, solution.calculate(input)); // = 2
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase9(Solution solution) {
    final String input = "1 - (-7)";
    assertEquals(8, solution.calculate(input)); // = 2
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}