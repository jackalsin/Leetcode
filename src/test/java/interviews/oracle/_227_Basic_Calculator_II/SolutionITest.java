package interviews.oracle._227_Basic_Calculator_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhixi
 * @version 1.0 on 11/28/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnline1(Solution solution) {
    final String input = "3+2*2";
    assertEquals(7, solution.calculate(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnline2(Solution solution) {
    final String input = " 3/2 ";
    assertEquals(1, solution.calculate(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnline3(Solution solution) {
    final String input = " 3+5 / 2 ";
    assertEquals(5, solution.calculate(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}