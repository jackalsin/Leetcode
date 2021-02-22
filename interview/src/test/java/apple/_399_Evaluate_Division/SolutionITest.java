package apple._399_Evaluate_Division;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 2/22/2021
 */
class SolutionITest {
  private static final double BIAS = 1E-8;

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c")),
        queries = List.of(
            List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x"));
    final double[] values = {2.0, 3.0};
    final double[] expected = {6.0, 0.5, -1.0, 1.0, -1.0};
    final double[] actual = solution.calcEquation(equations, values, queries);
    assertArrayEquals(expected, actual, BIAS);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}