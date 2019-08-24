package interviews.linkedin._069_Sqrt_x;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test1(Solution solution) {
    assertEquals(1, solution.mySqrt(1));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test2(Solution solution) {
    assertEquals(1, solution.mySqrt(2));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test3(Solution solution) {
    assertEquals(1, solution.mySqrt(3));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test4(Solution solution) {
    assertEquals(2, solution.mySqrt(4));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test5(Solution solution) {
    assertEquals(2, solution.mySqrt(5));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test2147395599(Solution solution) {
    assertEquals(46339, solution.mySqrt(2147395599));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new BinarySearchSolution(),
        new BinarySearchSolutionI(),
        new NewtonSolution()
    );
  }
}