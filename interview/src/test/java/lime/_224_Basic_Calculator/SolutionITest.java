package lime._224_Basic_Calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/3/2021
 */
class SolutionITest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void test1Plus1(Solution solution) {
    assertEquals(2, solution.calculate("1 + 1"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test2Minus1Plus2(Solution solution) {
    assertEquals(3, solution.calculate(" 2-1 + 2"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testLine3(Solution solution) {
    assertEquals(23, solution.calculate("(1+(4+5+2)-3)+(6+8)"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test2147483647(Solution solution) {
    assertEquals(2147483647, solution.calculate("2147483647"));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}