package uber._399_Evaluate_Division;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;

class SolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"));
    final double[] values = {2.0, 3.0};
    final List<List<String>> queries = List.of(
        List.of("a", "c"), List.of("b", "c"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x")
    );
    final double[] expected = {6.00000, 3.00000, -1.00000, 1.00000, -1.00000};
    final double[] actual = solution.calcEquation(equations, values, queries);
    assertArrayEquals(expected, actual, 1E-5);
  }

}