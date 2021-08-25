package airbnb._224_Basic_Calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }

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

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test1Minus5(Solution solution) {
    assertEquals(-4, solution.calculate("1-(5)"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase1(Solution solution) {
    assertEquals(-15, solution.calculate("2-4-(8+2-6+(8+4-(1)+8-10))"));
  }
}